package controller;

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
        String returnMessage = null;
        String forwardTo = null;
        Boolean usernameOkay = null;



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


                User newUser = new User(firstName, lastName, username, email, password);

                 int someUser = genDao.insert(newUser);

                returnMessage = "Success!";

            }

            forwardTo = "/Madeline/signIn.jsp";
        }
        catch(Exception e){
            e.printStackTrace();
        }


        resp.setHeader("Refresh", "3; URL=" + forwardTo);

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
}
