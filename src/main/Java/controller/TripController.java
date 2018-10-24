package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A simple servlet to welcome the user.
 * @author pnorby
 */

@WebServlet(
        urlPatterns = {"/tripController"}
)

public class TripController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Get Trip information

        //Get Weather information

        //Get Message information

        //Get Supply information??

        //Redirect to trip jsp page

        RequestDispatcher dispatcher = req.getRequestDispatcher("/trip.jsp");
        dispatcher.forward(req, resp);


    }
}
