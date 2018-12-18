package controller;

import entity.Location;
import entity.Trip;
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

        }


        RequestDispatcher dispatcher = req.getRequestDispatcher("/directToAdmin");
        dispatcher.forward(req, resp);


    }
}
