package pl.lukaszlebiecki.paragraphgame.client.save;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pl.lukaszlebiecki.paragraphgame.domain.api.EquipmentService;
import pl.lukaszlebiecki.paragraphgame.domain.api.UserBasicInfo;
import pl.lukaszlebiecki.paragraphgame.domain.api.UserService;

import java.io.IOException;

@WebServlet("/save_equipment")
public class SaveEquipmentController extends HttpServlet {
    private UserService userService = new UserService();
    private EquipmentService equipmentService = new EquipmentService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getUserPrincipal() != null) {
            UserBasicInfo user = userService.findUser(request.getUserPrincipal().getName());
            String equipment = request.getParameter("equipment");
            if(!equipment.equals("")) {
            equipmentService.saveNewEquipmentThin(user.getUserId(), equipment);
            }
        }
        response.sendRedirect(request.getContextPath());
    }
}
