package controller;

import entity.Trip;
import persistence.GenericDao;

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
        urlPatterns = {"/messageController"}
)

public class MessageController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Get Trip information
        GenericDao<Trip> tripDao = new GenericDao<>(Trip.class);
        Trip trip;
        String tripIdNum = req.getParameter("select");
        int tripId = Integer.parseInt(tripIdNum);

        try{
            trip = tripDao.getById(tripId);
            req.setAttribute("trip", trip);

        }
        catch (Exception e){
            e.printStackTrace();

        }
        //get trip by parameter


        //Get Weather information

        //Get Message information

        //Get Supply information??

        //Redirect to trip jsp page

        RequestDispatcher dispatcher = req.getRequestDispatcher("/trip.jsp");
        dispatcher.forward(req, resp);


    }
}