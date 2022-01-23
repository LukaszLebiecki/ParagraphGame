package pl.lukaszlebiecki.paragraphgame.client.delete;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pl.lukaszlebiecki.paragraphgame.domain.api.EquipmentService;
import pl.lukaszlebiecki.paragraphgame.domain.api.NoteService;
import pl.lukaszlebiecki.paragraphgame.domain.api.UserBasicInfo;
import pl.lukaszlebiecki.paragraphgame.domain.api.UserService;

import java.io.IOException;

@WebServlet("/delete_note")
public class DeleteNoteController extends HttpServlet {
    private UserService userService = new UserService();
    private NoteService noteService = new NoteService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserBasicInfo user = userService.findUser(request.getUserPrincipal().getName());
        String note = request.getParameter("delete_note");
        noteService.deleteNote(user.getUserId(), note);
        response.sendRedirect(request.getContextPath());
    }
}
