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
 * A simple servlet for admin to update a trip
 * @author pnorby
 */

@WebServlet(
        urlPatterns = {"/adminUpdateTrip"}
)

public class AdminUpdateTrip extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        GenericDao<Trip> tripDao = new GenericDao<>(Trip.class);
        GenericDao<User> userDao = new GenericDao<>(User.class);
        GenericDao<Location> locationDao = new GenericDao<>(Location.class);
        Trip aTrip;
        List<User> users;
        String tripId = req.getParameter("tripId");
        int theTripId = Integer.parseInt(tripId);
        String userId = req.getParameter("userId");
        int theId;
        User theUser;
        Location theLocation;
        String tripLocation = req.getParameter("tripLocation");
        int tripLocId;
        //will need to be a drop down value for now
        String tripName = req.getParameter("tripName");
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");

        LocalDate startDay;
        LocalDate endDay;

        try{
            aTrip = tripDao.getById(theTripId);

            if(strCheck(userId)){
                theId = Integer.parseInt(userId);
                theUser = userDao.getById(theId);
                aTrip.setTripCreator(theUser);

            }

            if(strCheck(tripLocation)){
                tripLocId = Integer.parseInt(tripLocation);
                theLocation = locationDao.getById(tripLocId);
                aTrip.setLocation(theLocation);
            }

            if(strCheck(tripName)){
                aTrip.setTripName(tripName);
            }

            if(strCheck(startDate)){
                startDay = LocalDate.parse(startDate);
                aTrip.setTripStartDate(startDay);
            }

            if(strCheck(endDate)){
                endDay = LocalDate.parse(endDate);
                aTrip.setTripEndDate(endDay);
            }


            tripDao.saveOrUpdate(aTrip);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/directToAdmin");
            dispatcher.forward(req, resp);


        }
        catch(Exception e){

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
