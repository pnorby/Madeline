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
import java.time.LocalDate;
import java.util.List;

/**
 * A simple servlet for admin to add a trip
 * @author pnorby
 */

@WebServlet(
        urlPatterns = {"/adminAddTrip"}
)

public class AdminAddTrip extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        GenericDao<Trip> tripDao = new GenericDao<>(Trip.class);
        GenericDao<User> userDao = new GenericDao<>(User.class);
        GenericDao<Location> locationDao = new GenericDao<>(Location.class);
        Trip aTrip;
        List<User> users;
        String userId = req.getParameter("userId");
        int theId = Integer.parseInt(userId);
        User theUser;
        Location theLocation;
        String tripLocation = req.getParameter("tripLocation");
        int tripLocId = Integer.parseInt(tripLocation);
        //will need to be a drop down value for now
        String tripName = req.getParameter("tripName");
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");

        LocalDate startDay = LocalDate.parse(startDate);
        LocalDate endDay = LocalDate.parse(endDate);
        String userName = (String)session.getAttribute("user");

        try{
            theUser = userDao.getById(theId);

            theLocation = locationDao.getById(tripLocId);

            aTrip = new Trip(theLocation, tripName, startDay, endDay, theUser);
            tripDao.insert(aTrip);


        }
        catch(Exception e){
            logger.error("There was a problem adding the trip");

            String responseMsg = "An error was encountered, please contact an administrator if problem persists";
            resp.setHeader("Refresh", "3; URL=homeController");
            resp.setContentType("text/html");
            PrintWriter out  = resp.getWriter();
            out.print("<h1>" + responseMsg + "</h1>");
            out.close();
        }


        RequestDispatcher dispatcher = req.getRequestDispatcher("/directToAdmin");
        dispatcher.forward(req, resp);


    }
}
