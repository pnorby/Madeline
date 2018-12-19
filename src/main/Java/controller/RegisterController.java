package controller;

import entity.Trip;
import entity.User;
import persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * A simple servlet to welcome the user.
 * @author pnorby
 */

@WebServlet(
        urlPatterns = {"/register"}
)

public class RegisterController extends HttpServlet {
    GenericDao<User> genDao = new GenericDao<>(User.class);
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //add user
        HttpSession session = req.getSession();


        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String username = req.getParameter("userName");
        String password = req.getParameter("pWord");
        String passwordConfirm = req.getParameter("pWordConfirm");
        String tripForJoiner = req.getParameter("tripId");
        String returnMessage = null;
        String forwardTo = null;
        Boolean usernameOkay = null;
        Set<Trip> startList = null;
        Trip firstTrip;
        GenericDao<Trip> tripDao = new GenericDao<>(Trip.class);
        User newUser;



        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || username.isEmpty() || password.isEmpty() || passwordConfirm.isEmpty()){
            returnMessage = "All Fields Must Contain a Value";
        } else if(!(password.equals(passwordConfirm))){
            returnMessage = "Passwords Must Match";
        } else {
            usernameOkay = checkUserName(username);
        }


        try{

            if (usernameOkay.equals(null) || usernameOkay.equals(false)) {
                returnMessage = "Username Already In Use";
            } else {
                newUser = new User(firstName, lastName, username, email, password);

                if (strCheck(tripForJoiner)){
                    int firstTripId = Integer.parseInt(tripForJoiner);
                    firstTrip = tripDao.getById(firstTripId);
                    startList.add(firstTrip);
                    newUser.setTripsAttending(startList);
                    int someUser = genDao.insert(newUser);


                } else {

                    int someUser = genDao.insert(newUser);
                }
                returnMessage = "Success!";
            }

            forwardTo = "/Madeline/signIn.jsp";
        }
        catch(Exception e){
            e.printStackTrace();
        }


        resp.setHeader("Refresh", "3; URL=" + forwardTo);
        resp.setContentType("text/html");
        PrintWriter out  = resp.getWriter();
        out.print("<h1>" + returnMessage + "</h1>");
        out.close();
        //re-direct to home controller sending user

        //RequestDispatcher dispatcher = req.getRequestDispatcher(forwardTo);
        //dispatcher.forward(req, resp);
    }

    private Boolean checkUserName(String uName){
        Integer size;
        Boolean userNameAvailable = false;
        try{
            size = genDao.getByPropertyEqual("userName", uName).size();
            if (size.equals(0)){
                userNameAvailable = true;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return userNameAvailable;
    }

    private Boolean strCheck(String s){
        Boolean passes = false;

        if(s != null && !s.isEmpty()) {
            passes = true;
        }

        return passes;
    }
}
