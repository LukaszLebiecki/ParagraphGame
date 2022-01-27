package pl.lukaszlebiecki.paragraphgame.client.home;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pl.lukaszlebiecki.paragraphgame.domain.api.*;
import pl.lukaszlebiecki.paragraphgame.domain.playerCard.PlayerCard;

import java.io.IOException;
import java.util.List;

@WebServlet("")
public class HomeController extends HttpServlet {

    private ParagraphService paragraphService = new ParagraphService();
    private EquipmentService equipmentService = new EquipmentService();
    private NoteService noteService = new NoteService();
    private PlayerCardService playerCardService = new PlayerCardService();
    private CharacteristicsService characteristicsService = new CharacteristicsService();
    private SkillsService skillsService = new SkillsService();
    private UserService userService = new UserService();

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
