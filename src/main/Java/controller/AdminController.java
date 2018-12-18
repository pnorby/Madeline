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
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A servlet for administrators.
 * @author pnorby
 */

@WebServlet(
        urlPatterns = {"/adminController"}
)

public class AdminController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String recordType = req.getParameter("recType");
        GenericDao<Trip> tripDao = new GenericDao<>(Trip.class);
        GenericDao<User> userDao = new GenericDao<>(User.class);
        GenericDao<Location> locDao = new GenericDao<>(Location.class);


        try{
            resp.setContentType("text/html");
            resp.setCharacterEncoding("UTF-8");
            // set the response type before sending data
            PrintWriter out  = resp.getWriter();


            if(recordType.equals("User")){

                List<User> allItems = userDao.getAll();
                printUsers(allItems, out);
            } else if (recordType.equals("Trip")){
                List<Trip> allItems = tripDao.getAll();
                printTrips(allItems, out);
            } else if (recordType.equals("Location")){
                List<Location> allItems = locDao.getAll();
                printLocations(allItems, out);
            }


            out.close();

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    private void printUsers(List<User> theItems, PrintWriter printer) {
        int propOne;
        String propTwo;
        String propThree;
        String propFour;
        String propFive;

        printer.print("<table id=\"allRecords\" class=\"table table-striped table-bordered\" style=\"width:100%\">");
        printer.print("<thead><tr><th>UserId</th><th>Username</th><th>First</th><th>Last</th><th>Email</th><th>Edit</th><th>Delete</th></tr></thead>");
        printer.print("<tbody>");



        for (User u : theItems) {
            propOne = u.getUserid();
            propTwo = u.getUserName();
            propThree = u.getFirstName();
            propFour = u.getLastName();
            propFive = u.getEmail();

            printer.print("<tr><td>" + propOne + "</td><td>" + propTwo + "</td><td>" + propThree + "</td><td>" + propFour + "</td><td>" + propFive + "</td><td><a href=\"/Madeline/addUpdateDirector?itemType=User&actionType=update&itemId=" + propOne + "\"><img src=\"images/pencil.jpg\"/></a></td><td><a href=\"/Madeline/deleteItem?itemType=User&id=" + propOne + "\"><img src=\"images/delete.png\"/></a></td></tr>");

        }
        printer.print("</tbody>");
        printer.print("<tfoot><tr><th>UserId</th><th>Username</th><th>First</th><th>Last</th><th>Email</th><th>Edit</th><th>Delete</th></tr></tfoot>");
        printer.print("</table>");

    }
        private void printTrips(List<Trip> theItems, PrintWriter printer){
            int propOne;
            int propTwo;
            String propThree;
            String propFour;
            String propFive;
            String propSix;
            printer.print("<table id=\"allRecords\" class=\"table table-striped table-bordered\" style=\"width:100%\">");
            printer.print("<thead><tr><th>TripId</th><th>TripLocation</th><th>TripCreator</th><th>TripName</th><th>TripStart</th><th>TripEnd</th><th>Edit</th><th>Delete</th></tr></thead>");
            printer.print("<tbody>");
            for(Trip t : theItems){
                propOne = t.getTripid();
                propTwo = t.getLocation().getId();
                propThree = t.getTripCreator().getUserName();
                propFour = t.getTripName();
                propFive = t.getTripStartDate().toString();
                propSix = t.getTripEndDate().toString();

                printer.print("<tr><td>" + propOne + "</td><td>" + propTwo + "</td><td>" + propThree + "</td><td>" + propFour + "</td><td>" + propFive + "</td><td>" + propSix + "</td><td><a href=\"/Madeline/addUpdateDirector?itemType=Trip&actionType=update&itemId=" + propOne + "\"><img src=\"images/pencil.jpg\"/></a></td><td><a href=\"/Madeline/deleteItem?itemType=Trip&id=" + propOne + "\"><img src=\"images/delete.png\"/></a></td></tr>");
            }
            printer.print("</tbody>");
            printer.print("<tfoot><tr><th>TripId</th><th>TripLocation</th><th>TripCreator</th><th>TripName</th><th>TripStart</th><th>TripEnd</th><th>Edit</th><th>Delete</th></tr></tfoot>");

            printer.print("</table>");
        }

        private void printLocations(List<Location> theItems, PrintWriter printer){
            int propOne;
            String propTwo;
            String propThree;
            String propFour;
            String propFive;
            String propSix;
            String propSeven;
            String propEight;

            printer.print("<table id=\"allRecords\" class=\"table table-striped table-bordered\" style=\"width:100%\">");
            printer.print("<thead><tr><th>LocationId</th><th>LocationName</th><th>Addressor</th><th>City</th><th>State</th><th>Zip</th><th>Desc</th><th>Type</th><th>Edit</th><th>Delete</th></tr></thead>");
            printer.print("<tbody>");
            for(Location l : theItems){
                propOne = l.getId();
                propTwo = l.getLocationName();
                propThree = l.getLocationAddress();
                propFour = l.getLocationCity();
                propFive = l.getLocationState();
                propSix = l.getLocationZip();
                propSeven = l.getLocationDescription();
                propEight = l.getLocationType();

                printer.print("<tr><td>" + propOne + "</td><td>" + propTwo + "</td><td>" + propThree + "</td><td>" + propFour + "</td><td>" + propFive + "</td><td>" + propSix + "</td><td>" + propSeven + "</td><td>" + propEight + "</td><td><a href=\"/Madeline/addUpdateDirector?itemType=Location&actionType=update&itemId=" + propOne + "\"><img src=\"images/pencil.jpg\"/></a></td><td><a href=\"/Madeline/deleteItem?itemType=Location&id=" + propOne + "\"><img src=\"images/delete.png\"/></a></td></tr>");

            }
            printer.print("</tbody>");
            printer.print("<tfoot><tr><th>LocationId</th><th>LocationName</th><th>Addressor</th><th>City</th><th>State</th><th>Zip</th><th>Desc</th><th>Type</th><th>Edit</th><th>Delete</th></tr></tfoot>");

            printer.print("</table>");
        }

    }