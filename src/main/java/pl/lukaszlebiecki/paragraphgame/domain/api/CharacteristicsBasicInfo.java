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

    public CharacteristicsBasicInfo(Integer strength, Integer skill, Integer power, Integer condition,
                                    Integer appearance, Integer education, Integer physique, Integer intelligence,
                                    Integer moveRate, Integer hitPoints, Integer sanity, Integer luck) {
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
}
