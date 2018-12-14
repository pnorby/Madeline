package controller;

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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A simple servlet to welcome the user.
 * @author pnorby
 */

@WebServlet(
        urlPatterns = {"/homeController"}
)

public class HomeController extends HttpServlet {
    GenericDao<Trip> genTripDao = new GenericDao<>(Trip.class);
    GenericDao<User> genUserDao = new GenericDao<>(User.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        //Get Trip Names and Ids to display on home page

        String theUserName;
        theUserName = (String)session.getAttribute("user");
        User theUser = null;
        Set<Trip> userTrips = null;
        Set<Trip> userTripsAttending = null;
        Set<Trip> allUserTrips = new HashSet<>();



        try{
            theUserName = (String)session.getAttribute("user");
            theUser =  getUserByUsername(theUserName);

            userTrips = theUser.getTripsCreated();
            userTripsAttending = theUser.getTripsAttending();

            for (Trip t : userTrips){
                allUserTrips.add(t);
            }
            //Thread.currentThread().sleep(3000);
            for (Trip t : userTripsAttending){
                allUserTrips.add(t);
            }



            session.setAttribute("allUserTrips", allUserTrips);
            req.setAttribute("userTrips", allUserTrips);


        }
        catch(Exception e){
            e.printStackTrace();
        }

        //Redirect to home jsp page
        req.setAttribute("displayUser", session.getAttribute("loggedIn"));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/home.jsp");
        dispatcher.forward(req, resp);


    }

    private User getUserByUsername(String theUserName){
        List<User> users;
        User theUser = null;
        try {
            users = genUserDao.getByPropertyEqual("userName", theUserName);
            if (users.size() == 1) {
                theUser = users.get(0);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return theUser;
    }
}
