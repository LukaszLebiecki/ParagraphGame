package pl.lukaszlebiecki.paragraphgame.domain.characteristics;

import pl.lukaszlebiecki.paragraphgame.domain.common.BaseDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CharacteristicsDao extends BaseDao {

    public Characteristics find(int idUser) {
        final String query = String.format("""
            SELECT 
            users_id, 
            strength, 
            skill, 
            power, 
            condit, 
            appearance, 
            education, 
            physique, 
            intelligence, 
            moverate, 
            hitpoints, 
            sanity, 
            luck,
            magic_point
            FROM
            characteristics
            WHERE
            users_id = %d
    """,idUser);

        try (
                Connection connection = getConnection();
                Statement statement = connection.createStatement()
                ) {
            ResultSet set = statement.executeQuery(query);
            Characteristics characteristics = null;
            while (set.next()) {
                characteristics = mapRow(set);
            }
            return characteristics;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private static Characteristics mapRow(ResultSet set) throws SQLException {
        int users_id = set.getInt("users_id");
        int strength = set.getInt("strength");
        int skill = set.getInt("skill");
        int power = set.getInt("power");
        int condition = set.getInt("condit");
        int appearance = set.getInt("appearance");
        int education = set.getInt("education");
        int physique = set.getInt("physique");
        int intelligence = set.getInt("intelligence");
        int moverate = set.getInt("moverate");
        int hitpoints = set.getInt("hitpoints");
        int sanity = set.getInt("sanity");
        int luck = set.getInt("luck");
        int magic_point = set.getInt("magic_point");
        return new Characteristics(users_id, strength, skill, power, condition, appearance, education, physique, intelligence,
                moverate, hitpoints, sanity, luck, magic_point );
    }
}
