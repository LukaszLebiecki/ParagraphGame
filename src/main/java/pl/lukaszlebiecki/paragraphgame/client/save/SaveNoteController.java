package pl.lukaszlebiecki.paragraphgame.client.save;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pl.lukaszlebiecki.paragraphgame.domain.api.NoteService;
import pl.lukaszlebiecki.paragraphgame.domain.api.UserBasicInfo;
import pl.lukaszlebiecki.paragraphgame.domain.api.UserService;

import java.io.IOException;

@WebServlet("/save_note")
public class SaveNoteController extends HttpServlet {
    private UserService userService = new UserService();
    private NoteService noteService = new NoteService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getUserPrincipal() != null) {
            UserBasicInfo user = userService.findUser(request.getUserPrincipal().getName());
            String note = request.getParameter("note");
            if(!note.equals("")) {
            noteService.saveNewNote(user.getUserId(), note);
            }
        }
        response.sendRedirect(request.getContextPath());
    }
}
