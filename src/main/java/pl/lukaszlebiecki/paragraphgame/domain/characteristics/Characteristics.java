package pl.lukaszlebiecki.paragraphgame.domain.characteristics;

public class Characteristics {
    private Integer userId;
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

    public Characteristics(Integer userId, Integer strength, Integer skill, Integer power, Integer condition,
                           Integer appearance, Integer education, Integer physique, Integer intelligence,
                           Integer moveRate, Integer hitPoints, Integer sanity, Integer luck, Integer magic_point) {
        this.userId = userId;
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

    public Integer getMagic_point() {
        return magic_point;
    }

    public void setMagic_point(Integer magic_point) {
        this.magic_point = magic_point;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getSkill() {
        return skill;
    }

    public void setSkill(Integer skill) {
        this.skill = skill;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getCondition() {
        return condition;
    }

    public void setCondition(Integer condition) {
        this.condition = condition;
    }

    public Integer getAppearance() {
        return appearance;
    }

    public void setAppearance(Integer appearance) {
        this.appearance = appearance;
    }

    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

    public Integer getPhysique() {
        return physique;
    }

    public void setPhysique(Integer physique) {
        this.physique = physique;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
    }

    public Integer getMoveRate() {
        return moveRate;
    }

    public void setMoveRate(Integer moveRate) {
        this.moveRate = moveRate;
    }

    public Integer getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(Integer hitPoints) {
        this.hitPoints = hitPoints;
    }

    public Integer getSanity() {
        return sanity;
    }

    public void setSanity(Integer sanity) {
        this.sanity = sanity;
    }

    public Integer getLuck() {
        return luck;
    }

    public void setLuck(Integer luck) {
        this.luck = luck;
    }
}


