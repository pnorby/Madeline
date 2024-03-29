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
 * A simple servlet for an admin to update a user.
 * @author pnorby
 */

@WebServlet(
        urlPatterns = {"/adminUpdateUser"}
)

public class AdminUpdateUser extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    GenericDao<User> userDao = new GenericDao<>(User.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //add user
        HttpSession session = req.getSession();

        String userId = req.getParameter("userId");
        int theId = Integer.parseInt(userId);
        User theUser;
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

            theUser = userDao.getById(theId);
            if(firstName != null && !firstName.isEmpty()) {
                theUser.setFirstName(firstName);
            }

            if(lastName != null && !lastName.isEmpty()) {
                theUser.setLastName(lastName);
            }

            if(username != null && !username.isEmpty()) {
                theUser.setUserName(username);
            }
            if(password != null && !password.isEmpty()) {
                theUser.setPassword(password);
            }
            if(email != null && !email.isEmpty()) {
                theUser.setEmail(email);
            }


            userDao.saveOrUpdate(theUser);



            forwardTo = "/directToAdmin";

            RequestDispatcher dispatcher = req.getRequestDispatcher(forwardTo);
            dispatcher.forward(req, resp);
        }
        catch(Exception e){
            logger.error("There was a problem updating the user");

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
            size = userDao.getByPropertyEqual("userName", uName).size();
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
