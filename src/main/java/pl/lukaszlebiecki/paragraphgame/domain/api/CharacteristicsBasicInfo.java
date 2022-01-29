package pl.lukaszlebiecki.paragraphgame.domain.api;

public class CharacteristicsBasicInfo {
    private Integer strength;
    private Integer skill;
    private Integer power;
    private Integer condition;
    private Integer appearance;
    private Integer education;
    private Integer physique;
    private Integer intelligence;
    private Integer moveRate;
    private Integer hitPoints;
    private Integer sanity;
    private Integer luck;
    private Integer magic_point;

    public CharacteristicsBasicInfo(Integer strength, Integer skill, Integer power, Integer condition,
                                    Integer appearance, Integer education, Integer physique, Integer intelligence,
                                    Integer moveRate, Integer hitPoints, Integer sanity, Integer luck, Integer magic_point) {
        this.strength = strength;
        this.skill = skill;
        this.power = power;
        this.condition = condition;
        this.appearance = appearance;
        this.education = education;
        this.physique = physique;
        this.intelligence = intelligence;
        this.moveRate = moveRate;
        this.hitPoints = hitPoints;
        this.sanity = sanity;
        this.luck = luck;
        this.magic_point = magic_point;
    }

    public Integer getStrength() {
        return strength;
    }

    public Integer getSkill() {
        return skill;
    }

    public Integer getPower() {
        return power;
    }

    public Integer getCondition() {
        return condition;
    }

    public Integer getAppearance() {
        return appearance;
    }

    public Integer getEducation() {
        return education;
    }

    public Integer getPhysique() {
        return physique;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    public Integer getMoveRate() {
        return moveRate;
    }

    public Integer getHitPoints() {
        return hitPoints;
    }

    public Integer getSanity() {
        return sanity;
    }

    public Integer getLuck() {
        return luck;
    }

    public Integer getMagic_point() {
        return magic_point;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public void setSkill(Integer skill) {
        this.skill = skill;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public void setCondition(Integer condition) {
        this.condition = condition;
    }

    public void setAppearance(Integer appearance) {
        this.appearance = appearance;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

    public void setPhysique(Integer physique) {
        this.physique = physique;
    }

    public void setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
    }

    public void setMoveRate(Integer moveRate) {
        this.moveRate = moveRate;
    }

    public void setHitPoints(Integer hitPoints) {
        this.hitPoints = hitPoints;
    }

    public void setSanity(Integer sanity) {
        this.sanity = sanity;
    }

    public void setLuck(Integer luck) {
        this.luck = luck;
    }

    public void setMagic_point(Integer magic_point) {
        this.magic_point = magic_point;
    }

    public int halfNumber(int number) {
        return number/2;
    }

    public int fifthNumber(int number) {
        return number/5;
    }
}
