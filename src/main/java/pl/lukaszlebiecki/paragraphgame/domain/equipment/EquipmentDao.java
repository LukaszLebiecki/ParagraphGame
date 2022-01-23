package pl.lukaszlebiecki.paragraphgame.domain.equipment;

import pl.lukaszlebiecki.paragraphgame.domain.common.BaseDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquipmentDao extends BaseDao {

    public void delete(int userId, String equipmentThink) {
        final String query = String.format("""
                DELETE FROM
                equipment
                WHERE
                users_id = %d
                AND
                equipment = '%s'
                """,userId, equipmentThink);
        try (
                Connection connection = getConnection();
                Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(int userId, String equipmentThink) {
        final String query = String.format("""
                INSERT INTO
                equipment (equipment, users_id)
                VALUES
                (?,?)
                """);

        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, equipmentThink);
            statement.setInt(2, userId);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Equipment> findAll(int idUser) {
        final String query = String.format("SELECT users_id, equipment FROM equipment WHERE users_id = %s", idUser);

        try (
                Connection connection = getConnection();
                Statement statement = connection.createStatement()
                ) {
            ResultSet resultSet = statement.executeQuery(query);
            List<Equipment> allEquipments = new ArrayList<>();
            while (resultSet.next()) {
                Equipment equipment = mapRow(resultSet);
                allEquipments.add(equipment);
            }
            return allEquipments;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Equipment mapRow(ResultSet set) throws SQLException {
        int users_id = set.getInt("users_id");
        String equipment = set.getString("equipment");
        return new Equipment(users_id, equipment);
    }
}
