package persistence;

import entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    UserDao dao;
    @BeforeEach
    void setUp() {
        dao = new UserDao();
    }

    @Test
    void getAllUsers() {
        List<User> users = dao.getAllUsers();
        assertEquals(6, users.size());
    }

    @Test
    void getUsersByLastName() {
        List<User> users = dao.getUsersByLastName("c");
        assertEquals(3, users.size());
    }

    /**
     * Verfies a user is returned correctly based on id search
     */
    @Test
    void getByIdSuccess() {
        User retrievedUser = dao.getById(3);
        assertEquals("Barney", retrievedUser.getFirstName());

    }

    /**
     * Verifies successful insert of a user
     */
    @Test
    void insertSuccess(){
        User newUser = new User("Paul", "Norby", "paulnorby", "pnorby@matc.com","supersecret");
        int id = dao.insert(newUser);
        assertNotEquals(0, id);
        User insertedUser = dao.getById(id);
        assertEquals("Paul", insertedUser.getFirstName());

    }
    /**
     * Verify successful update of user
     */
    @Test
    void updateSuccess() {
        String newLastName = "Davis";
        User userToUpdate = dao.getById(3);
        userToUpdate.setLastName(newLastName);
        dao.saveOrUpdate(userToUpdate);
        User retrievedUser = dao.getById(3);
        assertEquals(newLastName, retrievedUser.getLastName());
    }

    /**
     *  Verify successful get by property (equal match)
     */

    //@Test
    //void getByPropertyEqualSuccess(){
      //  List<User> users = dao.getByPropertyLike("lastName", "Curry");
        //assertEquals(1, users.size());
        //assertEquals(3, users.get(0).getId());
    //}

}