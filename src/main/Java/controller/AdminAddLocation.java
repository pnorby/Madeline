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
import java.time.LocalDate;
import java.util.List;

/**
 * A simple servlet for admin to add a location
 * @author pnorby
 */

@WebServlet(
        urlPatterns = {"/adminAddLocation"}
)

public class AdminAddLocation extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        GenericDao<Location> locationDao = new GenericDao<>(Location.class);
        String locName = req.getParameter("locationName");
        String locAddress = req.getParameter("address");
        String locCity = req.getParameter("city");
        String locState = req.getParameter("state");
        String locZip = req.getParameter("zip");
        String locDesc = req.getParameter("description");
        String locType = req.getParameter("type");

        Location theLocation;

        try{
            theLocation = new Location(locName, locAddress, locCity, locState, locZip, locDesc, locType);

            int someLocation = locationDao.insert(theLocation);

        }
        catch(Exception e){
            logger.error("There was a problem adding the location");

            String responseMsg = "An error was encountered, please contact an administrator if problem persists";
            resp.setHeader("Refresh", "3; URL=homeController");
            resp.setContentType("text/html");
            PrintWriter out  = resp.getWriter();
            out.print("<h1>" + responseMsg + "</h1>");
            out.close();
        }


        RequestDispatcher dispatcher = req.getRequestDispatcher("/directToAdmin");
        dispatcher.forward(req, resp);


    }
}
