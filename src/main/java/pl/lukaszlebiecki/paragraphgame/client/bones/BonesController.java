package pl.lukaszlebiecki.paragraphgame.client.bones;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Objects;

@WebServlet("/bones")
public class BonesController extends HttpServlet {
    public static final Bones bones = new Bones();
    private final BonesLogic bonesLogic = new BonesLogic();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String k100 = request.getParameter("k100");
        if (Objects.equals(k100, "k100")) {
            bonesLogic.k100Random(bones);
        } else {
            bones.setK100(0);
        }

        String k61 = request.getParameter("k61");
        if (Objects.equals(k61, "k61")) {
            bonesLogic.k61Random(bones);
        } else {
            bones.setK6_1(0);
        }

        String k62 = request.getParameter("k62");
        if (Objects.equals(k62, "k62")) {
            bonesLogic.k62Random(bones);
        } else {
            bones.setK6_2(0);
        }

        String k63 = request.getParameter("k63");
        if (Objects.equals(k63, "k63")) {
            bonesLogic.k63Random(bones);
        } else {
            bones.setK6_3(0);
        }

        String k4 = request.getParameter("k4");
        if (Objects.equals(k4, "k4")) {
            bonesLogic.k4Random(bones);
        } else {
            bones.setK4(0);
        }

        String k3 = request.getParameter("k3");
        if (Objects.equals(k3, "k3")) {
            bonesLogic.k3Random(bones);
        } else {
            bones.setK3(0);
        }

        String k2 = request.getParameter("k2");
        if (Objects.equals(k2, "k2")) {
            bonesLogic.k2Random(bones);
        } else {
            bones.setK2(0);
        }

        response.sendRedirect(request.getContextPath());
    }
}
