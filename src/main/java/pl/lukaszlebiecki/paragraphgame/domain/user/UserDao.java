package pl.lukaszlebiecki.paragraphgame.domain.user;

import pl.lukaszlebiecki.paragraphgame.domain.api.UserBasicInfo;
import pl.lukaszlebiecki.paragraphgame.domain.common.BaseDao;

import java.sql.*;

public class UserDao extends BaseDao {

    final static private int PARAGRAPH_START = 1;

    public void save(User user) {
        saveUser(user);
        saveUserRole(user);
    }


    public void update(int userId, int newParagraphMainId) {
        updateParagraphMainId(userId, newParagraphMainId);
    }

    private void saveUser(User user) {
        final String query = """
                INSERT INTO
                users (username, email, password, registration_date, paragraph_main_id)
                VALUES
                (?, ?, ?, ?, ?)
                """;

        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                    statement.setString(1, user.getUserName());
                    statement.setString(2, user.getEmail());
                    statement.setString(3, user.getPassword());
                    statement.setObject(4, user.getRegistrationDate());
                    statement.setInt(5, PARAGRAPH_START);
                    statement.executeUpdate();
                    ResultSet generatedKeys = statement.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        user.setUserId(generatedKeys.getInt(1));
                        user.setParagraphMainNumber(PARAGRAPH_START);
                    }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    private void saveUserRole(User user) {
        final String query = """
                        INSERT INTO
                            user_role (username)
                        VALUES
                            (?)
                        """;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getUserName());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        }

    private void updateParagraphMainId(int userId, int newParagraphMainId) {
        final String query = String.format("""
                UPDATE
                users
                SET
                paragraph_main_id = %d
                WHERE
                id = %d
                """, newParagraphMainId, userId);

        try ( Connection connection = getConnection();
              PreparedStatement statement = connection.prepareStatement(query)) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public UserBasicInfo findUserByName(String userName) {
        final String query = String.format("""
                SELECT
                id,
                username,
                paragraph_main_id
                FROM
                users
                WHERE
                username = '%s'
                """, userName);

        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery(query);
            UserBasicInfo userBasicInfo = null;
            while (resultSet.next()) {
                userBasicInfo = new UserBasicInfo(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        (resultSet.getInt("paragraph_main_id") -1));
            }
            return userBasicInfo;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
