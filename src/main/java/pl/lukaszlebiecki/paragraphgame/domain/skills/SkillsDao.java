package pl.lukaszlebiecki.paragraphgame.domain.skills;

import pl.lukaszlebiecki.paragraphgame.domain.common.BaseDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SkillsDao extends BaseDao {

    public Skills find(int idUser) {
        final String query = String.format("""
                SELECT
                users_id,
                anthropology,
                archeology,
                firearm,
                disguise,
                electricity,
                talk,
                history,
                horse_riding,
                foreign_language,
                native_language,
                use_libraries,
                bookkeeping,
                wealth,
                mechanics,
                medicine,
                cthulhu,
                listening,
                science,
                navigation,
                occultism,
                persuasion,
                first_aid,
                swimming,
                law,
                driving,
                psychology,
                throwing,
                jumping,
                observation,
                survival,
                ironwork,
                tracking,
                hiding,
                dodge,
                personal_charm,
                hand_combat,
                knowledge_of_nature,
                climbing,
                quotation,
                bullying,
                skillful_fingers
                FROM
                skills
                WHERE
                users_id = %d
                """, idUser);
        try (
                Connection connection = getConnection();
                Statement statement = connection.createStatement()
                ) {
            ResultSet set = statement.executeQuery(query);
            Skills skills = null;
            while (set.next()) {
                skills = mapRow(set);
            }
            return skills;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    private static Skills mapRow(ResultSet set) throws SQLException{
        int users_id = set.getInt("users_id");
        int anthropology = set.getInt("anthropology");
        int archeology = set.getInt("archeology");
        int firearm = set.getInt("firearm");
        int disguise = set.getInt("disguise");
        int electricity = set.getInt("electricity");
        int talk = set.getInt("talk");
        int history = set.getInt("history");
        int horse_riding = set.getInt("horse_riding");
        int foreign_language = set.getInt("foreign_language");
        int native_language = set.getInt("native_language");
        int use_libraries = set.getInt("use_libraries");
        int bookkeeping = set.getInt("bookkeeping");
        int wealth = set.getInt("wealth");
        int mechanics = set.getInt("mechanics");
        int medicine = set.getInt("medicine");
        int cthulhu = set.getInt("cthulhu");
        int listening = set.getInt("listening");
        int science = set.getInt("science");
        int navigation = set.getInt("navigation");
        int occultism = set.getInt("occultism");
        int persuasion = set.getInt("persuasion");
        int first_aid = set.getInt("first_aid");
        int swimming = set.getInt("swimming");
        int law = set.getInt("law");
        int driving = set.getInt("driving");
        int psychology = set.getInt("psychology");
        int throwing = set.getInt("throwing");
        int jumping = set.getInt("jumping");
        int observation = set.getInt("observation");
        int survival = set.getInt("survival");
        int ironwork = set.getInt("ironwork");
        int tracking = set.getInt("tracking");
        int hiding = set.getInt("hiding");
        int dodge = set.getInt("dodge");
        int personal_charm = set.getInt("personal_charm");
        int hand_combat = set.getInt("hand_combat");
        int knowledge_of_nature = set.getInt("knowledge_of_nature");
        int climbing = set.getInt("climbing");
        int quotation = set.getInt("quotation");
        int bullying = set.getInt("bullying");
        int skillful_fingers = set.getInt("skillful_fingers");
        return new Skills(users_id, anthropology, archeology, firearm, disguise, electricity, talk, history,
                horse_riding, foreign_language, native_language, use_libraries, bookkeeping, wealth, mechanics,
                medicine, cthulhu, listening, science, navigation, occultism, persuasion, first_aid, swimming,
                law, driving, psychology, throwing, jumping, observation, survival, ironwork, tracking, hiding,
                dodge, personal_charm, hand_combat, knowledge_of_nature, climbing, quotation,
                bullying, skillful_fingers);
    }
}
