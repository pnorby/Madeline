package controller;

import persistence.GenericDao;

import javax.servlet.RequestDispatcher;
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
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //add user
        HttpSession session = req.getSession();
        GenericDao genDao = new GenericDao();

        //String firstName = req.getParameter();
        //String lastName = req.getParameter();
        //String email = req.getParameter();
        //String username = req.getParameter();
        //String password = req.getParameter();
        //String passwordConfirm = req.getParameter();
        //String errorMessage = null;
        //String forwardTo = null;

        //if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty() || passwordConfirm.isEmpty()){

        //}

        //Boolean usernameOkay = genDao.checkUsername(username);

        //if(!(password.equals(passwordConfirm)) || usernameOkay.equals(false)){

        //}




        //re-direct to home controller sending user

        //RequestDispatcher dispatcher = req.getRequestDispatcher(forwardTo);
        //dispatcher.forward(req, resp);
    }
}
