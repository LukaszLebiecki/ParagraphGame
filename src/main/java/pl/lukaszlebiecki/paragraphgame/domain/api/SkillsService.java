package pl.lukaszlebiecki.paragraphgame.domain.api;

import pl.lukaszlebiecki.paragraphgame.domain.skills.Skills;
import pl.lukaszlebiecki.paragraphgame.domain.skills.SkillsDao;

public class SkillsService {
    private final SkillsDao skillsDao = new SkillsDao();

    public SkillsBasicInfo find(int idUser) {
        return SkillsMapper.map(skillsDao.find(idUser));
    }

    private static class SkillsMapper {
        static SkillsBasicInfo map(Skills s) {
            return new SkillsBasicInfo(
                    s.getAnthropology(),
                    s.getArcheology(),
                    s.getFirearm(),
                    s.getDisguise(),
                    s.getElectricity(),
                    s.getTalk(),
                    s.getHistory(),
                    s.getHorseRiding(),
                    s.getForeignLanguage(),
                    s.getNativeLanguage(),
                    s.getUseLibraries(),
                    s.getBookkeeping(),
                    s.getWealth(),
                    s.getMechanics(),
                    s.getMedicine(),
                    s.getCthulhu(),
                    s.getListening(),
                    s.getScience(),
                    s.getNavigation(),
                    s.getOccultism(),
                    s.getPersuasion(),
                    s.getFirstAid(),
                    s.getSwimming(),
                    s.getLaw(),
                    s.getDriving(),
                    s.getPsychology(),
                    s.getThrowing(),
                    s.getJumping(),
                    s.getObservation(),
                    s.getSurvival(),
                    s.getIronwork(),
                    s.getTracking(),
                    s.getHiding(),
                    s.getDodge(),
                    s.getPersonalCharm(),
                    s.getHandCombat(),
                    s.getKnowledgeOfNature(),
                    s.getClimbing(),
                    s.getQuotation(),
                    s.getBullying(),
                    s.getSkillfulFingers()
            );
        }
    }
}
