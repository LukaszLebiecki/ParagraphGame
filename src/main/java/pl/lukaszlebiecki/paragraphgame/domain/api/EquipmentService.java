package pl.lukaszlebiecki.paragraphgame.domain.api;

import pl.lukaszlebiecki.paragraphgame.domain.equipment.Equipment;
import pl.lukaszlebiecki.paragraphgame.domain.equipment.EquipmentDao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EquipmentService {

    private final EquipmentDao equipmentDao = new EquipmentDao();

    public void deleteEquipment(int userId, String equipmentThink) {
        equipmentDao.delete(userId, equipmentThink);
    }

    public void saveNewEquipmentThin(int userId, String equipmentThink) {
        equipmentDao.save(userId, equipmentThink);
    }

    public List<EquipmentBasicInfo> findAll(int idUser) {
        List<EquipmentBasicInfo> equipmentBasicInfos = new ArrayList<>();
        return equipmentDao.findAll(idUser)
                .stream().map(EquipmentAllMapper::map)
                .collect(Collectors.toList());
    }

    private static class EquipmentAllMapper {
        static EquipmentBasicInfo map(Equipment e) {
            return new EquipmentBasicInfo(
                    e.getEquipment()
            );
        }
    }
}
