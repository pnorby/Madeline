package controller;

import entity.Location;
import entity.Trip;
import entity.User;
import persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Set;

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
        HttpSession session = req.getSession();
        GenericDao<Trip> tripDao = new GenericDao<>(Trip.class);
        GenericDao<Location> locDao = new GenericDao<>(Location.class);
        GenericDao<User> userDao = new GenericDao<>(User.class);
        List<Location> locations = locDao.getAll();
        String userName = (String)session.getAttribute("user");
        List<User> users = userDao.getByPropertyEqual("userName", userName);
        User theUser = users.get(0);
        Set<Trip> userTrips = theUser.getTripsCreated();
        req.setAttribute("userTrips", userTrips);
        Boolean loggedIn = (Boolean)session.getAttribute("loggedIn");
        req.setAttribute("locations", locations);
        req.setAttribute("loggedIn", loggedIn);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/planTrip.jsp");
        dispatcher.forward(req, resp);


    }
}
