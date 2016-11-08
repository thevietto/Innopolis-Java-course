package inno;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/cookies")
public class CookiesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("addNew") != null) {
            Cookie cookie = new Cookie("cookiename", "cookieValue");
            cookie.setMaxAge(20);
            resp.addCookie(cookie);
        }

        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            resp.getWriter().print(cookie.getName() + " : " + cookie.getValue() + "; \n");
        }

    }
}
