package pl.lukaszlebiecki.paragraphgame.domain.paragraph;

public class ParagraphChoice {

    private String description;
    private Integer paragraphNext;
    private Integer paragraphNumber;

    public ParagraphChoice(String description, Integer paragraphNext, Integer paragraphNumber) {
        this.description = description;
        this.paragraphNext = paragraphNext;
        this.paragraphNumber = paragraphNumber;
    }

    public String getDescription() {
        return description;
    }

    public Integer getParagraphNext() {
        return paragraphNext;
    }

    public Integer getParagraphNumber() {
        return paragraphNumber;
    }
}
