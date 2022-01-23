package pl.lukaszlebiecki.paragraphgame.client.delete;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pl.lukaszlebiecki.paragraphgame.domain.api.EquipmentService;
import pl.lukaszlebiecki.paragraphgame.domain.api.UserBasicInfo;
import pl.lukaszlebiecki.paragraphgame.domain.api.UserService;

import java.io.IOException;

@WebServlet("/delete_equipment")
public class DeleteEquipmentController extends HttpServlet {
    private UserService userService = new UserService();
    private EquipmentService equipmentService = new EquipmentService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserBasicInfo user = userService.findUser(request.getUserPrincipal().getName());
        String equipment = request.getParameter("delete_equipment");
        equipmentService.deleteEquipment(user.getUserId(), equipment);
        response.sendRedirect(request.getContextPath());
    }
}
