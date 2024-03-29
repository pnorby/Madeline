package persistence;

import entity.Location;
import entity.Trip;
import entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TripDaoTest {

    TripDao dao;
    @BeforeEach
    void setUp() {
        dao = new TripDao();
    }

    @Test
    void getAllTrips() {
        List<Trip> trips = dao.getAllTrips();
        assertEquals(1, trips.size());
    }

    /**
     * Verfies a trip is returned correctly based on id search
     */
    @Test
    void getByIdSuccess() {
        Trip retrievedTrip = dao.getById(4);
        assertEquals("test", retrievedTrip.getTripName());

    }

    /**
     * Verifies successful insert of a trip
     */
    /*8@Test
    void insert(){
        LocationDao locationDao = new LocationDao();
        UserDao userDao = new UserDao();
        Location location = locationDao.getById(1);
        User user = userDao.getById(1);

        Trip newTrip = new Trip(location,"Test Trip", start, end, user);
        location.addTrip(newTrip);
        int id = dao.insert(newTrip);
        assertNotEquals(0, id);
        Trip insertedTrip = dao.getById(id);
        assertNotNull(insertedTrip);
        assertEquals(start, insertedTrip.getTripStartDate());

    }
    /**
     * Verify successful update of trip
     */
    @Test
    void updateSuccess() {
        String newTripName = "Test Trip2";
        Trip tripToUpdate = dao.getById(4);
        tripToUpdate.setTripName(newTripName);
        dao.saveOrUpdate(tripToUpdate);
        Trip retrievedTrip = dao.getById(4);
        assertEquals(newTripName, retrievedTrip.getTripName());
    }
}
