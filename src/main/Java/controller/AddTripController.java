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
import java.time.LocalDate;
import java.util.List;

/**
 * A simple servlet to welcome the user.
 * @author pnorby
 */

@WebServlet(
        urlPatterns = {"/addTripController"}
)

public class AddTripController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        GenericDao<Trip> tripDao = new GenericDao<>(Trip.class);
        GenericDao<User> userDao = new GenericDao<>(User.class);
        GenericDao<Location> locationDao = new GenericDao<>(Location.class);
        Trip aTrip;
        List<User> users;
        User theUser;
        Location theLocation;
        String tripLocation = req.getParameter("tripLocation");
        int tripLocId = Integer.parseInt(tripLocation);
        //will need to be a drop down value for now
        String tripName = req.getParameter("tripName");
        //String startDate = req.getParameter("startDate");
        //String endDate = req.getParameter("endDate");
        String startDate = "2018-12-19";
        String endDate = "2018-12-26";
        LocalDate startDay = LocalDate.parse(startDate);
        LocalDate endDay = LocalDate.parse(endDate);
        String userName = (String)session.getAttribute("user");

        try{
            users = userDao.getByPropertyEqual("userName", userName);
            theUser = users.get(0);
            theLocation = locationDao.getById(tripLocId);
            System.out.println(userName);
            System.out.println(startDate + endDate);
            System.out.println(tripName);
            aTrip = new Trip(theLocation, tripName, startDay, endDay, theUser);
            tripDao.insert(aTrip);







        }
            catch(Exception e){

        }


        RequestDispatcher dispatcher = req.getRequestDispatcher("/homeController");
        dispatcher.forward(req, resp);


    }
}
