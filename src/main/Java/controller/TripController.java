package controller;

import entity.Location;
import entity.Message;
import entity.Trip;
import entity.User;
import persistence.GenericDao;
import utilities.TripMessageUtil;

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
import java.util.Set;
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
        List<User> users;
        User user;
        List<List<String>> rows;
        List<Message> tripMessages = null;
        Set<User> attendees = null;



        int i = 0;


        try{
            users = userDao.getByPropertyEqual("userName", theUser);
            user = users.get(0);
            trip = tripDao.getById(tripId);
            attendees = trip.getUsers();

            TripMessageUtil tmu = new TripMessageUtil(trip);
            tripMessages = tmu.getWebViewMessages();

            rows = getWeatherRows(trip);
            Set<Trip> userTrips = (Set<Trip>)session.getAttribute("allUserTrips");
            req.setAttribute("attendees", attendees);
            req.setAttribute("userTrips", userTrips);
            req.setAttribute("tripMessages", tripMessages);
            req.setAttribute("trip", trip);
            req.setAttribute("user", user);
            req.setAttribute("weatherRows", rows);

        }
        catch (Exception e){
            e.printStackTrace();

        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/trip.jsp");
        dispatcher.forward(req, resp);

    }

    private List<List<String>> getWeatherRows(Trip trip){
        int numDays;
        String tripZip;
        String day;
        LocalDate tripStart;
        LocalDate tripEnd;
        Location tripLoc;
        LocalDate lastWeatherDay;
        LocalDate thisDay;
        LocalDate selectedDay;
        List<String> days = new ArrayList<String>();
        int i;


        thisDay = LocalDate.now();
        lastWeatherDay = thisDay.plusDays(4);
        tripLoc = trip.getLocation();
        tripZip = tripLoc.getLocationZip();
        tripStart = trip.getTripStartDate();
        tripEnd = trip.getTripEndDate();
        List<List<String>> rows = new ArrayList<List<String>>();

        //tripEnd = tripEnd.plusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
        List<LocalDate> dates = Stream.iterate(tripStart, date -> date.plusDays(1))
                .limit(ChronoUnit.DAYS.between(tripStart, tripEnd.plusDays(1)))
                .collect(Collectors.toList());

        List<LocalDate> weatherDates = Stream.iterate(thisDay, date -> date.plusDays(1))
                .limit(ChronoUnit.DAYS.between(thisDay, lastWeatherDay.plusDays(1)))
                .collect(Collectors.toList());

        numDays = dates.size();

        for (i = 1; i <= numDays; i++){
            selectedDay = dates.get(i-1);
            if(i == numDays){

                if (weatherDates.contains(selectedDay)) {
                    day = (weatherDates.indexOf(selectedDay)) + "-" + tripZip;
                } else{
                    day = "outOfRange";
                }
                days.add(day);
                rows.add(days);
            }
            else if (( i % 6) == 0){
                if (weatherDates.contains(selectedDay)) {
                    day = (weatherDates.indexOf(selectedDay)) + "-" + tripZip;
                } else{
                    day = "outOfRange";
                }
                days.add(day);
                rows.add(days);

                days = new ArrayList<>();
            } else {

                if (weatherDates.contains(selectedDay)) {
                    day = (weatherDates.indexOf(selectedDay)) + "-" + tripZip;
                } else{
                    day = "outOfRange";
                }

                days.add(day);
            }
        }
        return rows;
    }


}
