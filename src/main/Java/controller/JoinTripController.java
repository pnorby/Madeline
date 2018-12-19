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
 * A servlet to allow an invited person to join a trip
 * @author pnorby
 */

@WebServlet(
        urlPatterns = {"/joinTrip"}
)

public class JoinTripController extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        GenericDao<User> userDao = new GenericDao<>(User.class);
        GenericDao<Trip> tripDao = new GenericDao<>(Trip.class);
        String recipEmail = req.getParameter("recipientEmail");
        String theTripId = req.getParameter("trip");
        int tripId;
        Set<User> tripUsers;
        List<User> users;
        User theUser;
        Trip theTrip;
        String forwardTo = "";
        Boolean newUserJoining = false;
        String responseMessage;


        try{

            users = userDao.getByPropertyEqual("email" , recipEmail);

            if(users.size() == 1){
                theUser = users.get(0);

                if(strCheck(theTripId)){
                    tripId = Integer.parseInt(theTripId);
                    theTrip = tripDao.getById(tripId);
                    tripUsers = theTrip.getUsers();

                    if(tripUsers.contains(theUser)){
                        responseMessage = "You are already registered with this trip";
                        forwardTo = "/signIn.jsp";
                    } else {


                        tripUsers.add(theUser);
                        theTrip.setUsers(tripUsers);
                        tripDao.saveOrUpdate(theTrip);
                        responseMessage = "You have been added to the trip!";
                        forwardTo = "/signIn.jsp";

                        resp.setHeader("Refresh", "3; URL=" + forwardTo);
                        resp.setContentType("text/html");
                        PrintWriter out  = resp.getWriter();
                        out.print("<h1>" + responseMessage + "</h1>");
                        out.close();
                    }

                }

            } else {
                //forward to SIGN UP controller with parameters denoting they are joining this trip?
                newUserJoining = true;
                req.setAttribute("joiningTrip", newUserJoining);
                req.setAttribute("theTrip" , theTripId);
                RequestDispatcher dispatcher = req.getRequestDispatcher("/signUp.jsp");
                dispatcher.forward(req, resp);

            }

        }
        catch(Exception e){
            logger.error("There was a problem joining the a trip");

            String responseMsg = "An error was encountered, please contact an administrator if problem persists";
            resp.setHeader("Refresh", "3; URL=homeController");
            resp.setContentType("text/html");
            PrintWriter out  = resp.getWriter();
            out.print("<h1>" + responseMsg + "</h1>");
            out.close();
        }

    }

    private Boolean strCheck(String s){
        Boolean passes = false;

        if(s != null && !s.isEmpty()) {
            passes = true;
        }

        return passes;
    }
}
