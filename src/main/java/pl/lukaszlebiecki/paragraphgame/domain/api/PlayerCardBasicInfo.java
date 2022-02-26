package pl.lukaszlebiecki.paragraphgame.domain.api;

import pl.lukaszlebiecki.paragraphgame.domain.playerCard.PlayerSex;

public class PlayerCardBasicInfo {
    private String namePlayer = "";
    private String occupation = "";
    private Integer age;
    private PlayerSex sex;
    private String residence = "";
    private String birthplace = "";

    public PlayerCardBasicInfo() {
    }

    public PlayerCardBasicInfo(String namePlayer, String occupation, Integer age, PlayerSex sex, String residence, String birthplace) {
        this.namePlayer = namePlayer;
        this.occupation = occupation;
        this.age = age;
        this.sex = sex;
        this.residence = residence;
        this.birthplace = birthplace;
    }

    public String getNamePlayer() {
        return namePlayer;
    }

    public String getOccupation() {
        return occupation;
    }

    public Integer getAge() {
        return age;
    }

    public PlayerSex getSex() {
        return sex;
    }

    public String getResidence() {
        return residence;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSex(PlayerSex sex) {
        this.sex = sex;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }
}
