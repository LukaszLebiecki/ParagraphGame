package pl.lukaszlebiecki.paragraphgame.domain.api;

import pl.lukaszlebiecki.paragraphgame.domain.skills.Skills;
import pl.lukaszlebiecki.paragraphgame.domain.skills.SkillsDao;

public class SkillsService {
    private final SkillsDao skillsDao = new SkillsDao();

    public SkillsBasicInfo find(int idUser) {
        return SkillsMapper.map(skillsDao.find(idUser));
    }

    public void updateSkills(int userId, Integer anthropology, Integer archeology, Integer firearm, Integer disguise,
                             Integer electricity, Integer talk, Integer history, Integer horseRiding,
                             Integer foreignLanguage, Integer nativeLanguage, Integer useLibraries,
                             Integer bookkeeping, Integer wealth, Integer mechanics, Integer medicine,
                             Integer cthulhu, Integer listening, Integer science, Integer navigation,
                             Integer occultism, Integer persuasion, Integer firstAid, Integer swimming,
                             Integer law, Integer driving, Integer psychology, Integer throwing, Integer jumping,
                             Integer observation, Integer survival, Integer ironwork, Integer tracking,
                             Integer hiding, Integer dodge, Integer personalCharm, Integer handCombat,
                             Integer knowledgeOfNature, Integer climbing, Integer quotation, Integer bullying,
                             Integer skillfulFingers) {
        skillsDao.update(userId, anthropology, archeology, firearm, disguise,
                electricity, talk, history, horseRiding,
                foreignLanguage, nativeLanguage, useLibraries,
                bookkeeping, wealth, mechanics, medicine,
                cthulhu, listening, science, navigation,
                occultism, persuasion, firstAid, swimming,
                law, driving, psychology, throwing, jumping,
                observation, survival, ironwork, tracking,
                hiding, dodge, personalCharm, handCombat,
                knowledgeOfNature, climbing, quotation, bullying,
                skillfulFingers);
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
