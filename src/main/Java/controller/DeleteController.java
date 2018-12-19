package controller;

import entity.Location;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * A servlet to delete items from db
 * @author pnorby
 */

@WebServlet(
        urlPatterns = {"/deleteItem"}
)

public class DeleteController extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String itemType = req.getParameter("itemType");
        String itemId = req.getParameter("id");
        int theId = Integer.parseInt(itemId);
        GenericDao<User> userDao;
        GenericDao<Trip> tripDao;
        GenericDao<Location> locDao;

        try{
            if(itemType.equals("User")){
                userDao = new GenericDao<>(User.class);
                User userToDelete = userDao.getById(theId);
                userDao.delete(userToDelete);

            }else if(itemType.equals("Trip")){
                tripDao = new GenericDao<>(Trip.class);
                Trip tripToDelete = tripDao.getById(theId);
                tripDao.delete(tripToDelete);

            }else if(itemType.equals("Location")){
                locDao = new GenericDao<>(Location.class);
                Location locationToDelete = locDao.getById(theId);
                locDao.delete(locationToDelete);

            }

            RequestDispatcher dispatcher = req.getRequestDispatcher("/directToAdmin");
            dispatcher.forward(req, resp);

        }
        catch(Exception e){
            logger.error("There was a problem deleting an item");

            String responseMsg = "An error was encountered, please contact an administrator if problem persists";
            resp.setHeader("Refresh", "3; URL=homeController");
            resp.setContentType("text/html");
            PrintWriter out  = resp.getWriter();
            out.print("<h1>" + responseMsg + "</h1>");
            out.close();
        }


    }
}
