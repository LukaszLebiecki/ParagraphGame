package pl.lukaszlebiecki.paragraphgame.client.home;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pl.lukaszlebiecki.paragraphgame.client.bones.Bones;
import pl.lukaszlebiecki.paragraphgame.client.bones.BonesController;
import pl.lukaszlebiecki.paragraphgame.domain.api.*;
import pl.lukaszlebiecki.paragraphgame.domain.playerCard.PlayerCard;

import java.io.IOException;
import java.util.List;

@WebServlet("")
public class HomeController extends HttpServlet {

    private final ParagraphService paragraphService = new ParagraphService();
    private final EquipmentService equipmentService = new EquipmentService();
    private final NoteService noteService = new NoteService();
    private final PlayerCardService playerCardService = new PlayerCardService();
    private final CharacteristicsService characteristicsService = new CharacteristicsService();
    private final SkillsService skillsService = new SkillsService();
    private final UserService userService = new UserService();

    List<ParagraphBasicInfo> paragraphs = paragraphService.findAll();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getUserPrincipal() != null) {
            UserBasicInfo user = userService.findUser(request.getUserPrincipal().getName());
            ParagraphBasicInfo paragraph = paragraphs.get(user.getParagraphMainNumber());
            loadingData(request, user, paragraph);

            PlayerCardBasicInfo playerCard = playerCardService.find(user.getUserId());
            request.setAttribute("playerCard", playerCard);

            CharacteristicsBasicInfo characteristics = characteristicsService.find(user.getUserId());
            request.setAttribute("characteristics", characteristics);

            SkillsBasicInfo skills = skillsService.find(user.getUserId());
            request.setAttribute("skills", skills);
        }

        int k100 = BonesController.bones.getK100();
        request.setAttribute("k100", k100);

        int k61 = BonesController.bones.getK6_1();
        request.setAttribute("k61", k61);

        int k62 = BonesController.bones.getK6_2();
        request.setAttribute("k62", k62);

        int k63 = BonesController.bones.getK6_3();
        request.setAttribute("k63", k63);

        int k4 = BonesController.bones.getK4();
        request.setAttribute("k4", k4);

        int k3 = BonesController.bones.getK3();
        request.setAttribute("k3", k3);

        int k2 = BonesController.bones.getK2();
        request.setAttribute("k2", k2);



        request.getRequestDispatcher("WEB-INF/views/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserBasicInfo user = userService.findUser(request.getUserPrincipal().getName());

        String next_paragraph = request.getParameter("next_paragraph");
        int nextParagraph = Integer.parseInt(next_paragraph);
        ParagraphBasicInfo paragraph = paragraphs.get(nextParagraph - 1);
        userService.updateParagraph(13, nextParagraph);

        loadingData(request, user, paragraph);


        request.getRequestDispatcher("WEB-INF/views/index.jsp").forward(request, response);
    }

    private void loadingData(HttpServletRequest request, UserBasicInfo user, ParagraphBasicInfo paragraph) {
        request.setAttribute("paragraph", paragraph);

        List<EquipmentBasicInfo> equipments = equipmentService.findAll(user.getUserId());
        request.setAttribute("equipments", equipments);

        List<NoteBasicInfo> notes = noteService.findAll(user.getUserId());
        request.setAttribute("notes", notes);
    }
}
