package pl.lukaszlebiecki.paragraphgame.domain.paragraph;

import pl.lukaszlebiecki.paragraphgame.domain.common.BaseDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ParagraphDao extends BaseDao {

    public List<Paragraph> findAll() {
        final String query = "SELECT id, description FROM paragraph_main";
        try
                (Connection connection = getConnection();
                Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            List<Paragraph> allParagraph = new ArrayList<>();
            while (resultSet.next()) {
                Paragraph paragraph = mapRow(resultSet);
                allParagraph.add(paragraph);
            }
            return allParagraph;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Paragraph mapRow(ResultSet set) throws SQLException {
        int paragraphId = set.getInt("id");
        String description = set.getString("description");
        return new Paragraph(paragraphId, description);
    }
}
