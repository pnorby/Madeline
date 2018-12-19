package controller;

import entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
 * A simple servlet for an admin to add a user.
 * @author pnorby
 */

@WebServlet(
        urlPatterns = {"/adminAddUser"}
)

public class AdminAddUser extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    GenericDao<User> generDao = new GenericDao<>(User.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

        try{

            if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || username.isEmpty() || password.isEmpty() || passwordConfirm.isEmpty()){
                returnMessage = "All Fields Must Contain a Value";
            } else if(!(password.equals(passwordConfirm))){
                returnMessage = "Passwords Must Match";
            } else {
                usernameOkay = checkUserName(username);
            }


            if (usernameOkay.equals(null) || usernameOkay.equals(false)) {
                returnMessage = "Username Already In Use";
            } else {


                User newUser = new User(firstName, lastName, username, email, password);

                int someUser = generDao.insert(newUser);

                returnMessage = "Success!";

            }

            forwardTo = "/directToAdmin";

            RequestDispatcher dispatcher = req.getRequestDispatcher(forwardTo);
            dispatcher.forward(req, resp);
        }
        catch(Exception e){
            logger.error("There was a problem adding the user");

            String responseMsg = "An error was encountered, please contact an administrator if problem persists";
            resp.setHeader("Refresh", "3; URL=homeController");
            resp.setContentType("text/html");
            PrintWriter out  = resp.getWriter();
            out.print("<h1>" + responseMsg + "</h1>");
            out.close();
        }



    }

    private Boolean checkUserName(String uName){
        Integer size;
        Boolean userNameAvailable = false;
        try{
            size = generDao.getByPropertyEqual("userName", uName).size();
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
