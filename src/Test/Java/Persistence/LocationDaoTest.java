package Persistence;

import org.junit.jupiter.api.BeforeEach;

public class LocationDaoTest {

    UserDao dao;
    @BeforeEach
    void setUp() {
        dao = new UserDao();
    }
}
