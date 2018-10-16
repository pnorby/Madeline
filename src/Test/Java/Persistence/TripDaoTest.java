package Persistence;

import org.junit.jupiter.api.BeforeEach;

public class TripDaoTest {

    UserDao dao;
    @BeforeEach
    void setUp() {
        dao = new UserDao();
    }
}
