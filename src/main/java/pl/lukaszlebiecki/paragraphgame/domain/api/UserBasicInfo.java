package pl.lukaszlebiecki.paragraphgame.domain.api;

public class UserBasicInfo {
    private Integer userId;
    private String userName;
    private Integer paragraphMainNumber;

    public UserBasicInfo(Integer userId, String userName, Integer paragraphMainNumber) {
        this.userId = userId;
        this.userName = userName;
        this.paragraphMainNumber = paragraphMainNumber;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public Integer getParagraphMainNumber() {
        return paragraphMainNumber;
    }
}
