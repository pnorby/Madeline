package controller;

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
import java.sql.SQLDataException;
import java.util.List;

/**
 * A simple servlet to welcome the user.
 * @author pnorby
 */

@WebServlet(
        urlPatterns = {"/logIn"}
)

public class SignInController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Boolean logIn = false;
        String forwardTo = null;
        //validate user
        GenericDao<User> genDao = new GenericDao<>(User.class);
        String userName = req.getParameter("userName");
        String pWord = req.getParameter("password");
        String returnMessage = "";
        logIn = validateSignIn(userName, pWord);

        if (logIn){
            forwardTo = "/homeController";
            session.setAttribute("loggedIn", logIn);

        }else {

            forwardTo = "/index.jsp";
            returnMessage = "Unable to Log-In, Please Try Again or Contact Customer Service";
            session.setAttribute("message", returnMessage);
        }

        //re-direct to home controller sending user

        RequestDispatcher dispatcher = req.getRequestDispatcher(forwardTo);
        dispatcher.forward(req, resp);
    }

    private Boolean validateSignIn(String userName, String passWord){
        List<User> returnedUsers = null;
        GenericDao<User> genDao = new GenericDao<>(User.class);

        Boolean validated = false;

        try{

            returnedUsers = genDao.getByUsername(userName);
            if(returnedUsers.size() != 1){

                //LOG MESSAGE!
            }

            for (User u : returnedUsers){
                if (u.getPassword().equals(passWord)) {
                    validated = true;
                } else{
                    validated = false;
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return validated;
    }
}
