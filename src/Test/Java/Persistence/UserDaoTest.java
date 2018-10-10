package Persistence;

import Entity.User;
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

}