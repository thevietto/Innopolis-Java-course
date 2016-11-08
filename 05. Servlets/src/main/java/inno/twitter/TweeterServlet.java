package inno.twitter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/twitter")
public class TweeterServlet extends HttpServlet {

    private TweetService service;

    @Override
    public void init() throws ServletException {
        service = new TweetService();
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Tweet> tweets = service.getAll();
        req.setAttribute("tweets", tweets);
        req.getRequestDispatcher("/tweets.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String message = req.getParameter("message");
        service.add(message);
        resp.sendRedirect("/twitter");
    }
}
