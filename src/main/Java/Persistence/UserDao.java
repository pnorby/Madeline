package Persistence;
import Entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.model.relational.Database;

import javax.persistence.criteria.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;





public class UserDao {
    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();


    public List<User> getAllUsers() {

            Session session = sessionFactory.openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<User> query = builder.createQuery(User.class);
            Root<User> root = query.from(User.class);
            List<User> users = session.createQuery(query).getResultList();
            session.close();
            return users;

    }

    private User createUserFromResults(ResultSet results) throws SQLException {
        User user = new User();
        user.setLastName(results.getString("last_name"));
        user.setFirstName(results.getString("first_name"));
        user.setUserName(results.getString("username"));
        user.setId(results.getInt("Id"));
        user.setEmail(results.getString("email"));

        return user;
    }
}
