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
        }

        response.sendRedirect(request.getContextPath());
    }
}
