package pl.lukaszlebiecki.paragraphgame.domain.playerCard;

public class PlayerCard {
    private Integer userId;
    private String namePlayer;
    private String occupation;
    private Integer age;
    private PlayerSex sex;
    private String residence;
    private String birthplace;

    public PlayerCard(Integer userId, String namePlayer, String occupation, Integer age, PlayerSex sex, String residence, String birthplace) {
        this.userId = userId;
        this.namePlayer = namePlayer;
        this.occupation = occupation;
        this.age = age;
        this.sex = sex;
        this.residence = residence;
        this.birthplace = birthplace;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getNamePlayer() {
        return namePlayer;
    }

    public void setNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public PlayerSex getSex() {
        return sex;
    }

    public void setSex(PlayerSex sex) {
        this.sex = sex;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }
}
