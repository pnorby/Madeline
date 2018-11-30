package controller;

import entity.Location;
import entity.Trip;
import persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * A simple servlet to welcome the user.
 * @author pnorby
 */

@WebServlet(
        urlPatterns = {"/planTripController"}
)

public class PlanTripController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Get Trip information
        GenericDao<Trip> genDao = new GenericDao<>(Trip.class);
        GenericDao<Location> locDao = new GenericDao<>(Location.class);
        List<Location> locations = locDao.getAll();

        req.setAttribute("locations", locations);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/planTrip.jsp");
        dispatcher.forward(req, resp);


    }
}
