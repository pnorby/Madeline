package controller;

import entity.Message;
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
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 * A simple servlet to log trip messages
 * @author pnorby
 */

@WebServlet(
        urlPatterns = {"/messageController"}
)

public class MessageController extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

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

        LocalTime currentTime = LocalTime.now();
        LocalDate currentDay = LocalDate.now();
        LocalDateTime theSentTime = currentDay.atTime(currentTime);
        String reDirectTo;

        try{
            int tripId = Integer.parseInt(tripIdNum);
            int userId = Integer.parseInt(userIdNum);
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

            logger.error("There was a problem sending the message");
            String responseMessage = "An error was encountered, please contact an administrator if problem persists";
            resp.setHeader("Refresh", "3; URL=homeController");
            resp.setContentType("text/html");
            PrintWriter out  = resp.getWriter();
            out.print("<h1>" + responseMessage + "</h1>");
            out.close();

        }



    }


}
