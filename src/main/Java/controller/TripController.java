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
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A simple servlet to welcome the user.
 * @author pnorby
 */

@WebServlet(
        urlPatterns = {"/tripController"}
)

public class TripController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        //Get Trip information
        GenericDao<Trip> tripDao = new GenericDao<>(Trip.class);
        GenericDao<User> userDao = new GenericDao<>(User.class);
        Trip trip;
        String tripIdNum = req.getParameter("select");
        int tripId = Integer.parseInt(tripIdNum);
        String theUser = (String)session.getAttribute("user");
        Location tripLoc;
        List<User> users;
        User user;
        LocalDate tripStart;
        LocalDate tripEnd;
        List<List<String>> rows = new ArrayList<List<String>>();
        String day;
        List<String> days = new ArrayList<String>();
        String tripZip;

        int i = 0;
        int numDays;

        try{
            users = userDao.getByPropertyEqual("userName", theUser);
            user = users.get(0);
            trip = tripDao.getById(tripId);
            tripLoc = trip.getLocation();
            tripZip = tripLoc.getLocationZip();
            tripStart = trip.getTripStartDate();
            tripEnd = trip.getTripEndDate();


            //tripEnd = tripEnd.plusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
            List<LocalDate> dates = Stream.iterate(tripStart, date -> date.plusDays(1))
                    .limit(ChronoUnit.DAYS.between(tripStart, tripEnd.plusDays(1)))
                    .collect(Collectors.toList());

            numDays = dates.size();

            for (i = 1; i <= numDays; i++){
                if(i == numDays){
                    System.out.println(i);
                    day = (dates.get(i-1).toString()) + "-" + tripZip;
                    days.add(day);
                    rows.add(days);

                }
                else if (( i % 6) == 0){
                    day = (dates.get(i-1).toString()) + "-" + tripZip;
                    days.add(day);
                    rows.add(days);
                    System.out.println(days);
                    days = new ArrayList<String>();
                } else {
                    System.out.println(i);
                    day = (dates.get(i-1).toString()) + "-" + tripZip;
                    System.out.println(day);
                    days.add(day);
                }
            }
            System.out.println(rows.toString());
            req.setAttribute("trip", trip);
            req.setAttribute("user", user);
            req.setAttribute("weatherRows", rows);

        }
        catch (Exception e){
            e.printStackTrace();

        }
        //get trip by parameter


        //Get Weather information

        //Get Message information

        //Get Supply information??

        //Redirect to trip jsp page

        RequestDispatcher dispatcher = req.getRequestDispatcher("/trip.jsp");
        dispatcher.forward(req, resp);


    }
}
