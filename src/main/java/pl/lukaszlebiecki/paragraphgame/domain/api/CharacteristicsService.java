package pl.lukaszlebiecki.paragraphgame.domain.api;

import pl.lukaszlebiecki.paragraphgame.domain.characteristics.Characteristics;
import pl.lukaszlebiecki.paragraphgame.domain.characteristics.CharacteristicsDao;
import pl.lukaszlebiecki.paragraphgame.domain.playerCard.PlayerSex;

public class CharacteristicsService {
    private final CharacteristicsDao characteristicsDao = new CharacteristicsDao();

    public CharacteristicsBasicInfo find(int idUser) {
        return CharacteristicsMapper.map(characteristicsDao.find(idUser));
    }

    public void updateCharacteristics(int userId, Integer strength, Integer skill, Integer power, Integer condition,
                                      Integer appearance, Integer education, Integer physique, Integer intelligence,
                                      Integer moveRate, Integer hitPoints, Integer sanity, Integer luck, Integer magic_point) {
        characteristicsDao.update(userId, strength, skill, power, condition,
                appearance, education, physique, intelligence,
                moveRate, hitPoints, sanity, luck, magic_point);
    }

    private static class CharacteristicsMapper {
        static CharacteristicsBasicInfo map(Characteristics c) {
           return new CharacteristicsBasicInfo(
                   c.getStrength(),
                   c.getSkill(),
                   c.getPower(),
                   c.getCondition(),
                   c.getAppearance(),
                   c.getEducation(),
                   c.getPhysique(),
                   c.getIntelligence(),
                   c.getMoveRate(),
                   c.getHitPoints(),
                   c.getSanity(),
                   c.getLuck(),
                   c.getMagic_point()
           );
        }
    }
}
