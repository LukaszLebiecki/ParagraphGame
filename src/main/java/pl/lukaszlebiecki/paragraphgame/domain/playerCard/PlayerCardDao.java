package pl.lukaszlebiecki.paragraphgame.domain.playerCard;

import pl.lukaszlebiecki.paragraphgame.domain.common.BaseDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlayerCardDao extends BaseDao {

    public PlayerCard find(int idUser) {
        final String query = String.format("SELECT users_id, name, occupation, age, sex, residence, birthplace FROM player_card WHERE users_id = %d", idUser);

        try (
                Connection connection = getConnection();
                Statement statement = connection.createStatement()
                ) {
            ResultSet set = statement.executeQuery(query);
            PlayerCard playerCard = null;
            while (set.next()) {
                playerCard = mapRow(set);
            }
            return playerCard;

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static PlayerCard mapRow(ResultSet set) throws SQLException {
        Integer users_id = set.getInt("users_id");
        String name = set.getString("name");
        String occupation = set.getString("occupation");
        Integer age = set.getInt("age");
        PlayerSex sex = PlayerSex.valueOf(set.getString("sex"));
        String residence = set.getString("residence");
        String birthplace = set.getString("birthplace");

        return new PlayerCard(users_id, name, occupation, age, sex, residence, birthplace);
    }
}
