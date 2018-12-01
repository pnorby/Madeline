package controller;

import entity.Message;
import entity.Trip;
import persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        Message message = new Message();
        String tripIdNum = req.getParameter("tripNo");
        String userIdNum = req.getParameter("userNo");
        int tripId = Integer.parseInt(tripIdNum);
        int userId = Integer.parseInt(userIdNum);

        try{

            req.setAttribute("trip", trip);

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
