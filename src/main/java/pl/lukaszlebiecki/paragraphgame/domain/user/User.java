package pl.lukaszlebiecki.paragraphgame.domain.user;

import java.time.LocalDateTime;

public class User {
    private Integer userId;
    private String userName;
    private String password;
    private String email;
    private LocalDateTime registrationDate;
    private Integer paragraphMainNumber;

    public User(String userName, String password, String email, LocalDateTime registrationDate) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.registrationDate = registrationDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public Integer getParagraphMainNumber() {
        return paragraphMainNumber;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setParagraphMainNumber(Integer paragraphMainNumber) {
        this.paragraphMainNumber = paragraphMainNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


