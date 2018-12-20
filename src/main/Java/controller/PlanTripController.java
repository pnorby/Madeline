package controller;

import entity.Location;
import entity.Trip;
import entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

/**
 * A simple servlet to direct a user to plan a trip
 * @author pnorby
 */

@WebServlet(
        urlPatterns = {"/planTripController"}
)

public class PlanTripController extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        GenericDao<Trip> tripDao = new GenericDao<>(Trip.class);
        GenericDao<Location> locDao = new GenericDao<>(Location.class);
        GenericDao<User> userDao = new GenericDao<>(User.class);

        try {
            List<Location> locations = locDao.getAll();
            String userName = (String) session.getAttribute("user");
            List<User> users = userDao.getByPropertyEqual("userName", userName);
            User theUser = users.get(0);
            Set<Trip> userTrips = theUser.getTripsCreated();
            req.setAttribute("userTrips", userTrips);
            Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
            req.setAttribute("locations", locations);
            req.setAttribute("loggedIn", loggedIn);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/planTrip.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e){
            logger.error("There was a problem with plan trip controller");

            String responseMsg = "An error was encountered, please contact an administrator if problem persists";
            resp.setHeader("Refresh", "3; URL=homeController");
            resp.setContentType("text/html");
            PrintWriter out  = resp.getWriter();
            out.print("<h1>" + responseMsg + "</h1>");
            out.close();
        }


    }
}
