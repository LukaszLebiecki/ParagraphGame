package pl.lukaszlebiecki.paragraphgame.domain.notes;

import pl.lukaszlebiecki.paragraphgame.domain.common.BaseDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NoteDao extends BaseDao {

    public void delete(int userId, String note) {
        final String query = String.format("""
                DELETE FROM
                notes
                WHERE
                users_id = %d
                AND
                note = '%s'
                """,userId, note);
        try (
                Connection connection = getConnection();
                Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(int userId, String textNote) {
        final String query = String.format("""
                INSERT INTO
                notes (note, users_id)
                VALUES
                (?,?)
                """);

        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, textNote);
            statement.setInt(2, userId);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Note> findAll(int idUser) {
        final String query = String.format("SELECT users_id, note FROM notes WHERE users_id = %d ",idUser );
        try (
                Connection connection = getConnection();
                Statement statement = connection.createStatement()
                ) {
            ResultSet resultSet = statement.executeQuery(query);
            List<Note> allNotes = new ArrayList<>();
            while (resultSet.next()) {
                Note note = mapRow(resultSet);
                allNotes.add(note);
            }
            return allNotes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Note mapRow(ResultSet set) throws SQLException {
        int users_id = set.getInt("users_id");
        String note = set.getString("note");
        return new Note(users_id, note);
    }
}
