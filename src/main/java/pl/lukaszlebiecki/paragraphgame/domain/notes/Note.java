package pl.lukaszlebiecki.paragraphgame.domain.notes;

public class Note {
    private Integer userId;
    private String note;

    public Note(Integer userId, String note) {
        this.userId = userId;
        this.note = note;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getNote() {
        return note;
    }
}
