package pl.lukaszlebiecki.paragraphgame.domain.api;

import pl.lukaszlebiecki.paragraphgame.domain.characteristics.Characteristics;
import pl.lukaszlebiecki.paragraphgame.domain.characteristics.CharacteristicsDao;

public class CharacteristicsService {
    private final CharacteristicsDao characteristicsDao = new CharacteristicsDao();

    public CharacteristicsBasicInfo find(int idUser) {
        return CharacteristicsMapper.map(characteristicsDao.find(idUser));
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
