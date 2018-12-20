package controller;

import persistence.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A simple servlet
 * @author pnorby
 */

@WebServlet(
        urlPatterns = {"/allUsers"}
)

public class AllUsers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean initialLoad = true;
        UserDao userDao = new UserDao();
        req.setAttribute("users", userDao.getAllUsers());
        req.setAttribute("initial", initialLoad);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }
}
