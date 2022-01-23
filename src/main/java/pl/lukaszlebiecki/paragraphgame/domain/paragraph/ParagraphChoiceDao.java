package pl.lukaszlebiecki.paragraphgame.domain.paragraph;

import pl.lukaszlebiecki.paragraphgame.domain.common.BaseDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ParagraphChoiceDao extends BaseDao {

    public List<ParagraphChoice> findAll() {
        final String query = "SELECT paragraph_choice, paragraph_next_id, paragraph_main_id FROM paragraph_choice";

        try
                (Connection connection = getConnection();
                 Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            List<ParagraphChoice> allParagraphChoice = new ArrayList<>();
            while (resultSet.next()) {
                ParagraphChoice paragraphChoice = mapRow(resultSet);
                allParagraphChoice.add(paragraphChoice);
            }
            return allParagraphChoice;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static ParagraphChoice mapRow(ResultSet set) throws SQLException {
        String paragraph_choice = set.getString("paragraph_choice");
        int paragraph_next_id = set.getInt("paragraph_next_id");
        int paragraph_main_id = set.getInt("paragraph_main_id");
        return new ParagraphChoice(paragraph_choice, paragraph_next_id, paragraph_main_id);
    }
}
