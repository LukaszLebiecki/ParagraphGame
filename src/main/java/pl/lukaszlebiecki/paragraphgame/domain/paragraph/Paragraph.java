package pl.lukaszlebiecki.paragraphgame.domain.paragraph;

import java.util.List;

public class Paragraph {

    private Integer paragraphNumber;
    private String description;
    private List<ParagraphChoice> paragraphChoiceList;

    public Paragraph(Integer paragraphNumber, String description) {
        this.paragraphNumber = paragraphNumber;
        this.description = description;
    }

    public Integer getParagraphNumber() {
        return paragraphNumber;
    }

    public String getDescription() {
        return description;
    }

    public List<ParagraphChoice> getParagraphChoiceList() {
        return paragraphChoiceList;
    }

    public void setParagraphChoiceList(List<ParagraphChoice> paragraphChoiceList) {
        this.paragraphChoiceList = paragraphChoiceList;
    }
}
