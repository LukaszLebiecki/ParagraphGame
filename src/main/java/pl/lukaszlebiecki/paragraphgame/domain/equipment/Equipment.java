package pl.lukaszlebiecki.paragraphgame.domain.equipment;

import java.util.List;

public class Equipment {
    private Integer userId;
    private String equipment;

    public Equipment(Integer userId, String equipment) {
        this.userId = userId;
        this.equipment = equipment;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getEquipment() {
        return equipment;
    }
}
