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
        urlPatterns = {"/addTripController"}
)

public class AddTripController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        GenericDao<Trip> genDao = new GenericDao<>(Trip.class);
        GenericDao<User> userDao = new GenericDao<>(User.class);
        GenericDao<Location> locationDao = new GenericDao<>(Location.class);
        Boolean addSuccessful;
        List<User> users;
        User theUser;
        Location theLocation;
        String tripLocation = req.getParameter("tripLocation");
        int tripLocId = Integer.parseInt(tripLocation);
        //will need to be a drop down value for now
        String tripName = req.getParameter("tripName");
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");
        String userName = (String)session.getAttribute("user");

        try{
            users = userDao.getByPropertyEqual("username", userName);
            theUser = users.get(0);
            theLocation = locationDao.getById(tripLocId);




        }
            catch(Exception e){

        }


        RequestDispatcher dispatcher = req.getRequestDispatcher("/trip.jsp");
        dispatcher.forward(req, resp);


    }
}
