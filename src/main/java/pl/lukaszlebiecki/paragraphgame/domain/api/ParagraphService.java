package pl.lukaszlebiecki.paragraphgame.domain.api;

import pl.lukaszlebiecki.paragraphgame.domain.paragraph.Paragraph;
import pl.lukaszlebiecki.paragraphgame.domain.paragraph.ParagraphChoice;
import pl.lukaszlebiecki.paragraphgame.domain.paragraph.ParagraphChoiceDao;
import pl.lukaszlebiecki.paragraphgame.domain.paragraph.ParagraphDao;

import java.util.ArrayList;
import java.util.List;

public class ParagraphService {

    private final ParagraphDao paragraphDao = new ParagraphDao();
    private final ParagraphChoiceDao paragraphChoiceDao = new ParagraphChoiceDao();

    public List<ParagraphBasicInfo> findAll() {
        List<ParagraphBasicInfo> paragraphBasicInfos = new ArrayList<>();
        List<Paragraph> allParagraph = paragraphDao.findAll();
        for (int i = 0; i < allParagraph.size(); i++) {
            paragraphBasicInfos.add(new ParagraphBasicInfo(allParagraph.get(i).getParagraphNumber(),
                    allParagraph.get(i).getDescription(),
                    paragraphChoice(i+1)));
        }
        return paragraphBasicInfos;
    }

    private List<ParagraphChoice> paragraphChoice(int numberParagraph) {
        List<ParagraphChoice> paragraphChoices = new ArrayList<>();
        List<ParagraphChoice> allParagraphChoice = paragraphChoiceDao.findAll();
        for (int i = 0; i < allParagraphChoice.size(); i++) {
            if (numberParagraph == allParagraphChoice.get(i).getParagraphNumber()) {
                paragraphChoices.add(allParagraphChoice.get(i));
            }
        }
        return paragraphChoices;
    }


}
