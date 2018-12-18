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

/**
 * A simple servlet to welcome the user.
 * @author pnorby
 */

@WebServlet(
        urlPatterns = {"/addUpdateDirector"}
)

public class directToAddUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String addOrUpdate = req.getParameter("actionType");
        String itemType = req.getParameter("itemType");
        String itemId;
        int theId;
        boolean aTrip = false;
        boolean aLocation = false;
        boolean aUser = false;
        String forwardTo = "";

        try{

            if (addOrUpdate.equals("add")){
                forwardTo = "/newItem.jsp";

                if(itemType.equals("User")){

                    aUser = true;
                    req.setAttribute("aUser", aUser);
                } else if (itemType.equals("Trip")){
                    GenericDao<Location> locDao = new GenericDao<>(Location.class);

                    List<Location> locations = locDao.getAll();
                    req.setAttribute("locations", locations);
                    aTrip = true;
                    req.setAttribute("aTrip", aTrip);

                } else if (itemType.equals("Location")){

                    aLocation = true;
                    req.setAttribute("aLocation", aLocation);

                }

            } else if (addOrUpdate.equals("update")){
                forwardTo = "/updateItem.jsp";
                itemId = req.getParameter("itemId");
                theId = Integer.parseInt(itemId);

                if(itemType.equals("User")){
                    GenericDao<User> userDao = new GenericDao<>(User.class);
                    User user = userDao.getById(theId);
                    req.setAttribute("theUser", user);
                    aUser = true;
                    req.setAttribute("aUser", aUser);
                } else if (itemType.equals("Trip")){
                    GenericDao<Trip> tripDao = new GenericDao<>(Trip.class);
                    GenericDao<Location> locDao = new GenericDao<>(Location.class);
                    List<Location> locations = locDao.getAll();
                    req.setAttribute("locations", locations);
                    Trip trip = tripDao.getById(theId);
                    req.setAttribute("theTrip", trip);
                    aTrip = true;
                    req.setAttribute("aTrip", aTrip);

                } else if (itemType.equals("Location")){
                    GenericDao<Location> locDao = new GenericDao<>(Location.class);
                    Location location = locDao.getById(theId);
                    req.setAttribute("theLocation", location);
                    aLocation = true;
                    req.setAttribute("aLocation", aLocation);

                }



            }

            RequestDispatcher dispatcher = req.getRequestDispatcher(forwardTo);
            dispatcher.forward(req, resp);
        }
        catch(Exception e){
            e.printStackTrace();
        }


        RequestDispatcher dispatcher = req.getRequestDispatcher(forwardTo);
        dispatcher.forward(req, resp);


    }
}
