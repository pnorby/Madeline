package persistence;

import entity.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LocationDaoTest {

    LocationDao dao;
    @BeforeEach
    void setUp() {
        dao = new LocationDao();
    }

    @Test
    void getAllLocations() {
        List<Location> locations = dao.getAllLocations();
        assertEquals(6, locations.size());
    }

    /**
     * Verfies a user is returned correctly based on id search
     */
    @Test
    void getByIdSuccess() {
        Location retrievedLocation = dao.getById(1);
        assertEquals("Governor Dodge State Park", retrievedLocation.getLocationName());

    }

    /**
     * Verifies successful insert of a user
     */
    @Test
    void insertSuccess(){
        Location newLocation = new Location("Big Bay State Park", "123 First St.", "La Pointe", "WI", "55555", "a cool place", "Park");
        int id = dao.insert(newLocation);
        assertNotEquals(0, id);
        Location insertedLocation = dao.getById(id);
        assertEquals("Big Bay State Park", insertedLocation.getLocationName());

    }
    /**
     * Verify successful update of user
     */
    @Test
    void updateSuccess() {
        String newLocationName = "Big Bay";
        Location locationToUpdate = dao.getById(1);
        locationToUpdate.setLocationName(newLocationName);
        dao.saveOrUpdate(locationToUpdate);
        Location retrievedLocation = dao.getById(1);
        assertEquals(newLocationName, retrievedLocation.getLocationName());
    }
}
