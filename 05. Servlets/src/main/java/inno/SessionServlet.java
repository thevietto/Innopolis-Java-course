package inno;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet("/sessions")
public class SessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (req.getParameter("addNew") != null) {
            session.setAttribute("sessionkey", "sessionvalue");
        }

        resp.getWriter().write("value is " + session.getAttribute("sessionkey"));

        long second = (new Date().getTime() - session.getCreationTime()) / 1000;
        req.setCharacterEncoding("UTF-8");
        resp.getWriter().write("You are here for " + second + " seconds");
    }
}
