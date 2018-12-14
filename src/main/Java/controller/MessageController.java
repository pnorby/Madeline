package controller;

import entity.Message;
import entity.Trip;
import entity.User;
import persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 * A simple servlet to welcome the user.
 * @author pnorby
 */

@WebServlet(
        urlPatterns = {"/messageController"}
)

public class MessageController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao<Message> messageDao = new GenericDao<>(Message.class);
        GenericDao<Trip> tripDao = new GenericDao<>(Trip.class);
        GenericDao<User> userDao = new GenericDao<>(User.class);
        User user;
        Trip trip;
        Message message;
        String tripIdNum = req.getParameter("tripNo");
        String userIdNum = req.getParameter("uNo");
        String tripMessage = req.getParameter("tripMessage");
        int tripId = Integer.parseInt(tripIdNum);
        int userId = Integer.parseInt(userIdNum);
        LocalTime currentTime = LocalTime.now();
        LocalDate currentDay = LocalDate.now();
        LocalDateTime theSentTime = currentDay.atTime(currentTime);
        String reDirectTo;

        try{

            user = userDao.getById(userId);
            trip = tripDao.getById(tripId);
            message = new Message(trip, user, theSentTime, tripMessage);
            messageDao.insert(message);
            int tripInfo = trip.getTripid();
            reDirectTo = "tripController?select=" + tripInfo;
            req.setAttribute("trip", trip);
            req.setAttribute("user", user);

            RequestDispatcher dispatcher = req.getRequestDispatcher(reDirectTo);
            dispatcher.forward(req, resp);

        }
        catch (Exception e){
            e.printStackTrace();

        }



    }


}
