package pl.lukaszlebiecki.paragraphgame.domain.api;

import pl.lukaszlebiecki.paragraphgame.domain.paragraph.ParagraphChoice;

import java.util.List;

public class ParagraphBasicInfo {

    private int paragraphNumber;
    private String description;
    private List<ParagraphChoice> paragraphChoice;

    public ParagraphBasicInfo(int paragraphNumber, String description, List<ParagraphChoice> paragraphChoice) {
        this.paragraphNumber = paragraphNumber;
        this.description = description;
        this.paragraphChoice = paragraphChoice;
    }

    public int getParagraphNumber() {
        return paragraphNumber;
    }

    public String getDescription() {
        return description;
    }

    public List<ParagraphChoice> getParagraphChoice() {
        return paragraphChoice;
    }
}
