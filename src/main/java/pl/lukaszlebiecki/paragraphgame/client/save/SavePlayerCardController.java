package pl.lukaszlebiecki.paragraphgame.client.save;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pl.lukaszlebiecki.paragraphgame.domain.api.*;
import pl.lukaszlebiecki.paragraphgame.domain.characteristics.Characteristics;
import pl.lukaszlebiecki.paragraphgame.domain.playerCard.PlayerCard;
import pl.lukaszlebiecki.paragraphgame.domain.playerCard.PlayerSex;

import java.io.IOException;
import java.util.Objects;

@WebServlet("/save_player_card")
public class SavePlayerCardController extends HttpServlet {
    private final UserService userService = new UserService();
    private final PlayerCardService playerCardService = new PlayerCardService();
    private final CharacteristicsService characteristicsService = new CharacteristicsService();
    private final SkillsService skillsService = new SkillsService();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getUserPrincipal() != null) {
            UserBasicInfo user = userService.findUser(request.getUserPrincipal().getName());

            PlayerCardBasicInfo playerCardBasicInfo = playerCardService.find(user.getUserId());
            String name = request.getParameter("name");
            if (!Objects.equals(name, "")) {
                playerCardBasicInfo.setNamePlayer(name);
            }
            String occupation = request.getParameter("occupation");
            if (!Objects.equals(occupation, "")) {
                playerCardBasicInfo.setOccupation(occupation);
            }
            String ageString = request.getParameter("age");
            if (!Objects.equals(ageString, "")) {
                int age = Integer.parseInt(ageString);
                playerCardBasicInfo.setAge(age);
            }
            PlayerSex sex = PlayerSex.valueOf(request.getParameter("sex"));
            playerCardBasicInfo.setSex(sex);

            String residence = request.getParameter("residence");
            if (!Objects.equals(residence, "")) {
                playerCardBasicInfo.setResidence(residence);
            }
            String birthplace = request.getParameter("birthplace");
            if (!Objects.equals(birthplace, "")) {
                playerCardBasicInfo.setBirthplace(birthplace);
            }

            playerCardService.updatePlayerCard(
                    user.getUserId(),
                    playerCardBasicInfo.getNamePlayer(),
                    playerCardBasicInfo.getOccupation(),
                    playerCardBasicInfo.getAge(),
                    playerCardBasicInfo.getSex(),
                    playerCardBasicInfo.getResidence(),
                    playerCardBasicInfo.getBirthplace()
                    );

            CharacteristicsBasicInfo characteristicsBasicInfo = characteristicsService.find(user.getUserId());
            String strengthString = request.getParameter("strength");
            if (!Objects.equals(strengthString, "")) {
                int strength = Integer.parseInt(strengthString);
                characteristicsBasicInfo.setStrength(strength);
            }
            String skillString = request.getParameter("skill");
            if (!Objects.equals(skillString, "")) {
                int skill = Integer.parseInt(skillString);
                characteristicsBasicInfo.setSkill(skill);
            }
            String powerString = request.getParameter("power");
            if (!Objects.equals(powerString, "")) {
                int power = Integer.parseInt(powerString);
                characteristicsBasicInfo.setPower(power);
            }
            String conditionString = request.getParameter("condition");
            if (!Objects.equals(conditionString, "")) {
                int condition = Integer.parseInt(conditionString);
                characteristicsBasicInfo.setCondition(condition);
            }
            String appearanceString = request.getParameter("appearance");
            if (!Objects.equals(appearanceString, "")) {
                int appearance = Integer.parseInt(appearanceString);
                characteristicsBasicInfo.setAppearance(appearance);
            }
            String educationString = request.getParameter("education");
            if (!Objects.equals(educationString, "")) {
                int education = Integer.parseInt(educationString);
                characteristicsBasicInfo.setEducation(education);
            }
            String physiqueString = request.getParameter("physique");
            if (!Objects.equals(physiqueString, "")) {
                int physique = Integer.parseInt(physiqueString);
                characteristicsBasicInfo.setPhysique(physique);
            }
            String intelligenceString = request.getParameter("intelligence");
            if (!Objects.equals(intelligenceString, "")) {
                int intelligence = Integer.parseInt(intelligenceString);
                characteristicsBasicInfo.setIntelligence(intelligence);
            }
            String moveRateString = request.getParameter("moveRate");
            if (!Objects.equals(moveRateString, "")) {
                int moveRate = Integer.parseInt(moveRateString);
                characteristicsBasicInfo.setMoveRate(moveRate);
            }
            String hitPointsString = request.getParameter("hit_points");
            if (!Objects.equals(hitPointsString, "")) {
                int hitPoints = Integer.parseInt(hitPointsString);
                characteristicsBasicInfo.setHitPoints(hitPoints);
            }
            String sanityString = request.getParameter("sanity");
            if (!Objects.equals(sanityString, "")) {
                int sanity = Integer.parseInt(sanityString);
                characteristicsBasicInfo.setSanity(sanity);
            }
            String luckString = request.getParameter("luck");
            if (!Objects.equals(luckString, "")) {
                int luck = Integer.parseInt(luckString);
                characteristicsBasicInfo.setLuck(luck);
            }
            String magicPointsString = request.getParameter("magic_points");
            if (!Objects.equals(magicPointsString, "")) {
                int magicPoints = Integer.parseInt(magicPointsString);
                characteristicsBasicInfo.setMagic_point(magicPoints);
            }

            characteristicsService.updateCharacteristics(
                    user.getUserId(),
                    characteristicsBasicInfo.getStrength(),
                    characteristicsBasicInfo.getSkill(),
                    characteristicsBasicInfo.getPower(),
                    characteristicsBasicInfo.getCondition(),
                    characteristicsBasicInfo.getAppearance(),
                    characteristicsBasicInfo.getEducation(),
                    characteristicsBasicInfo.getPhysique(),
                    characteristicsBasicInfo.getIntelligence(),
                    characteristicsBasicInfo.getMoveRate(),
                    characteristicsBasicInfo.getHitPoints(),
                    characteristicsBasicInfo.getSanity(),
                    characteristicsBasicInfo.getLuck(),
                    characteristicsBasicInfo.getMagic_point()
                    );

            SkillsBasicInfo skillsBasicInfo = skillsService.find(user.getUserId());
            String anthropologyString = request.getParameter("anthropology");
            if (!Objects.equals(anthropologyString, "")) {
                int anthropology = Integer.parseInt(anthropologyString);
                skillsBasicInfo.setAnthropology(anthropology);
            }
            String archeologyString = request.getParameter("archeology");
            if (!Objects.equals(archeologyString, "")) {
                int archeology = Integer.parseInt(archeologyString);
                skillsBasicInfo.setArcheology(archeology);
            }
            String firearmString = request.getParameter("firearm");
            if (!Objects.equals(firearmString, "")) {
                int firearm = Integer.parseInt(firearmString);
                skillsBasicInfo.setFirearm(firearm);
            }
            String disguiseString = request.getParameter("disguise");
            if (!Objects.equals(disguiseString, "")) {
                int disguise = Integer.parseInt(disguiseString);
                skillsBasicInfo.setDisguise(disguise);
            }
            String electicityString = request.getParameter("electicity");
            if (!Objects.equals(electicityString, "")) {
                int electicity = Integer.parseInt(electicityString);
                skillsBasicInfo.setElectricity(electicity);
            }
            String talkString = request.getParameter("talk");
            if (!Objects.equals(talkString, "")) {
                int talk = Integer.parseInt(talkString);
                skillsBasicInfo.setTalk(talk);
            }
            String historyString = request.getParameter("history");
            if (!Objects.equals(historyString, "")) {
                int history = Integer.parseInt(historyString);
                skillsBasicInfo.setHistory(history);
            }
            String horseRidingString = request.getParameter("horse-riding");
            if (!Objects.equals(horseRidingString, "")) {
                int horseRiding = Integer.parseInt(horseRidingString);
                skillsBasicInfo.setHorseRiding(horseRiding);
            }
            String foreignLanguageString = request.getParameter("foreign-language");
            if (!Objects.equals(foreignLanguageString, "")) {
                int foreignLanguage = Integer.parseInt(foreignLanguageString);
                skillsBasicInfo.setForeignLanguage(foreignLanguage);
            }
            String nativeLanguageString = request.getParameter("native-language");
            if (!Objects.equals(nativeLanguageString, "")) {
                int nativeLanguage = Integer.parseInt(nativeLanguageString);
                skillsBasicInfo.setNativeLanguage(nativeLanguage);
            }
            String useLibrariesString = request.getParameter("use-libraries");
            if (!Objects.equals(useLibrariesString, "")) {
                int useLibraries = Integer.parseInt(useLibrariesString);
                skillsBasicInfo.setUseLibraries(useLibraries);
            }
            String bookkeepingString = request.getParameter("bookkeeping");
            if (!Objects.equals(bookkeepingString, "")) {
                int bookkeeping = Integer.parseInt(bookkeepingString);
                skillsBasicInfo.setBookkeeping(bookkeeping);
            }
            String wealthString = request.getParameter("wealth");
            if (!Objects.equals(wealthString, "")) {
                int wealth = Integer.parseInt(wealthString);
                skillsBasicInfo.setWealth(wealth);
            }
            String mechanicsString = request.getParameter("mechanics");
            if (!Objects.equals(mechanicsString, "")) {
                int mechanics = Integer.parseInt(mechanicsString);
                skillsBasicInfo.setMechanics(mechanics);
            }
            String medicineString = request.getParameter("medicine");
            if (!Objects.equals(medicineString, "")) {
                int medicine = Integer.parseInt(medicineString);
                skillsBasicInfo.setMedicine(medicine);
            }
            String cthulhuString = request.getParameter("cthulhu");
            if (!Objects.equals(cthulhuString, "")) {
                int cthulhu = Integer.parseInt(cthulhuString);
                skillsBasicInfo.setCthulhu(cthulhu);
            }
            String listeningString = request.getParameter("listening");
            if (!Objects.equals(listeningString, "")) {
                int listening = Integer.parseInt(listeningString);
                skillsBasicInfo.setListening(listening);
            }
            String scienceString = request.getParameter("science");
            if (!Objects.equals(scienceString, "")) {
                int science = Integer.parseInt(scienceString);
                skillsBasicInfo.setScience(science);
            }
            String navigationString = request.getParameter("navigation");
            if (!Objects.equals(navigationString, "")) {
                int navigation = Integer.parseInt(navigationString);
                skillsBasicInfo.setNavigation(navigation);
            }
            String occultismString = request.getParameter("occultism");
            if (!Objects.equals(occultismString, "")) {
                int occultism = Integer.parseInt(occultismString);
                skillsBasicInfo.setOccultism(occultism);
            }
            String persuasionString = request.getParameter("persuasion");
            if (!Objects.equals(persuasionString, "")) {
                int persuasion = Integer.parseInt(persuasionString);
                skillsBasicInfo.setPersuasion(persuasion);
            }
            String firstAidString = request.getParameter("first-aid");
            if (!Objects.equals(firstAidString, "")) {
                int firstAid = Integer.parseInt(firstAidString);
                skillsBasicInfo.setFirstAid(firstAid);
            }
            String swimmingString = request.getParameter("swimming");
            if (!Objects.equals(swimmingString, "")) {
                int swimming = Integer.parseInt(swimmingString);
                skillsBasicInfo.setSwimming(swimming);
            }
            String lawString = request.getParameter("law");
            if (!Objects.equals(lawString, "")) {
                int law = Integer.parseInt(lawString);
                skillsBasicInfo.setLaw(law);
            }
            String drivingString = request.getParameter("driving");
            if (!Objects.equals(drivingString, "")) {
                int driving = Integer.parseInt(drivingString);
                skillsBasicInfo.setDriving(driving);
            }
            String psychologyString = request.getParameter("psychology");
            if (!Objects.equals(psychologyString, "")) {
                int psychology = Integer.parseInt(psychologyString);
                skillsBasicInfo.setPsychology(psychology);
            }
            String throwingString = request.getParameter("throwing");
            if (!Objects.equals(throwingString, "")) {
                int throwing = Integer.parseInt(throwingString);
                skillsBasicInfo.setThrowing(throwing);
            }
            String jumpingString = request.getParameter("jumping");
            if (!Objects.equals(jumpingString, "")) {
                int jumping = Integer.parseInt(jumpingString);
                skillsBasicInfo.setJumping(jumping);
            }
            String observationString = request.getParameter("observation");
            if (!Objects.equals(observationString, "")) {
                int observation = Integer.parseInt(observationString);
                skillsBasicInfo.setObservation(observation);
            }
            String survivalString = request.getParameter("survival");
            if (!Objects.equals(survivalString, "")) {
                int survival = Integer.parseInt(survivalString);
                skillsBasicInfo.setSurvival(survival);
            }
            String ironworkString = request.getParameter("ironwork");
            if (!Objects.equals(ironworkString, "")) {
                int ironwork = Integer.parseInt(ironworkString);
                skillsBasicInfo.setIronwork(ironwork);
            }
            String trackingString = request.getParameter("tracking");
            if (!Objects.equals(trackingString, "")) {
                int tracking = Integer.parseInt(trackingString);
                skillsBasicInfo.setTracking(tracking);
            }
            String hidingString = request.getParameter("hiding");
            if (!Objects.equals(hidingString, "")) {
                int hiding = Integer.parseInt(hidingString);
                skillsBasicInfo.setHiding(hiding);
            }
            String dodgeString = request.getParameter("dodge");
            if (!Objects.equals(dodgeString, "")) {
                int dodge = Integer.parseInt(dodgeString);
                skillsBasicInfo.setDodge(dodge);
            }
            String personalCharmString = request.getParameter("personal-charm");
            if (!Objects.equals(personalCharmString, "")) {
                int personalCharm = Integer.parseInt(personalCharmString);
                skillsBasicInfo.setPersonalCharm(personalCharm);
            }
            String handCombatString = request.getParameter("hand-combat");
            if (!Objects.equals(handCombatString, "")) {
                int handCombat = Integer.parseInt(handCombatString);
                skillsBasicInfo.setHandCombat(handCombat);
            }
            String knowledgeOfNatureString = request.getParameter("knowledge-of-nature");
            if (!Objects.equals(knowledgeOfNatureString, "")) {
                int knowledgeOfNature = Integer.parseInt(knowledgeOfNatureString);
                skillsBasicInfo.setKnowledgeOfNature(knowledgeOfNature);
            }
            String climbingString = request.getParameter("climbing");
            if (!Objects.equals(climbingString, "")) {
                int climbing = Integer.parseInt(climbingString);
                skillsBasicInfo.setClimbing(climbing);
            }
            String quotationString = request.getParameter("quotation");
            if (!Objects.equals(quotationString, "")) {
                int quotation = Integer.parseInt(quotationString);
                skillsBasicInfo.setQuotation(quotation);
            }
            String bullyingString = request.getParameter("bullying");
            if (!Objects.equals(bullyingString, "")) {
                int bullying = Integer.parseInt(bullyingString);
                skillsBasicInfo.setBullying(bullying);
            }
            String skillfulFingersString = request.getParameter("skillful-fingers");
            if (!Objects.equals(skillfulFingersString, "")) {
                int skillfulFingers = Integer.parseInt(skillfulFingersString);
                skillsBasicInfo.setSkillfulFingers(skillfulFingers);
            }

            skillsService.updateSkills(
                    user.getUserId(),
                    skillsBasicInfo.getAnthropology(),
                    skillsBasicInfo.getArcheology(),
                    skillsBasicInfo.getFirearm(),
                    skillsBasicInfo.getDisguise(),
                    skillsBasicInfo.getElectricity(),
                    skillsBasicInfo.getTalk(),
                    skillsBasicInfo.getHistory(),
                    skillsBasicInfo.getHorseRiding(),
                    skillsBasicInfo.getForeignLanguage(),
                    skillsBasicInfo.getNativeLanguage(),
                    skillsBasicInfo.getUseLibraries(),
                    skillsBasicInfo.getBookkeeping(),
                    skillsBasicInfo.getWealth(),
                    skillsBasicInfo.getMechanics(),
                    skillsBasicInfo.getMedicine(),
                    skillsBasicInfo.getCthulhu(),
                    skillsBasicInfo.getListening(),
                    skillsBasicInfo.getScience(),
                    skillsBasicInfo.getNavigation(),
                    skillsBasicInfo.getOccultism(),
                    skillsBasicInfo.getPersuasion(),
                    skillsBasicInfo.getFirstAid(),
                    skillsBasicInfo.getSwimming(),
                    skillsBasicInfo.getLaw(),
                    skillsBasicInfo.getDriving(),
                    skillsBasicInfo.getPsychology(),
                    skillsBasicInfo.getThrowing(),
                    skillsBasicInfo.getJumping(),
                    skillsBasicInfo.getObservation(),
                    skillsBasicInfo.getSurvival(),
                    skillsBasicInfo.getIronwork(),
                    skillsBasicInfo.getTracking(),
                    skillsBasicInfo.getHiding(),
                    skillsBasicInfo.getDodge(),
                    skillsBasicInfo.getPersonalCharm(),
                    skillsBasicInfo.getHandCombat(),
                    skillsBasicInfo.getKnowledgeOfNature(),
                    skillsBasicInfo.getClimbing(),
                    skillsBasicInfo.getQuotation(),
                    skillsBasicInfo.getBullying(),
                    skillsBasicInfo.getSkillfulFingers()
            );

        }

        response.sendRedirect(request.getContextPath());
    }

}
