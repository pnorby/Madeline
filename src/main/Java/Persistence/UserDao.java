package Persistence;
import Entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;





public class UserDao {
    private final Logger logger = LogManager.getLogger(this.getClass());

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        Database database = Database.getInstance();
        Connection connection = null;
        String sql = "SELECT * FROM user";

        try {
            database.connect();
            connection = database.getConnection();
            Statement selectStatement = connection.createStatement();
            ResultSet results = selectStatement.executeQuery(sql);
            logger.info("Made it into getAllUsers");

            while (results.next()) {
                User employee = createUserFromResults(results);
                users.add(employee);
            }
            database.disconnect();
        } catch (SQLException sqle) {
            logger.error("SearchUser.getAllUsers()...SQL Exception: ", sqle);
        } catch (Exception e) {
            logger.error("SearchUser.getAllUsers()...Exception: ", e);
        }
        return users;
    }

    public List<User> getSearchedUsers(String searchCriteria) {
        List<User> users = new ArrayList<>();
        Database database = Database.getInstance();
        Connection connection = null;
        String sql = "SELECT * FROM user WHERE last_name like '" + searchCriteria + "%'";

        try {
            database.connect();
            connection = database.getConnection();
            Statement selectStatement = connection.createStatement();
            ResultSet results = selectStatement.executeQuery(sql);
            while (results.next()) {
                User employee = createUserFromResults(results);
                users.add(employee);
            }
            database.disconnect();
        } catch (SQLException e) {
            System.out.println("SearchUser.getSearchedUsers()...SQL Exception: " + e);
        } catch (Exception e) {
            System.out.println("SearchUser.getSearchedUsers()...Exception: " + e);
        }
        return users;

    }

    private User createUserFromResults(ResultSet results) throws SQLException {
        User user = new User();
        user.setLastName(results.getString("last_name"));
        user.setFirstName(results.getString("first_name"));
        user.setUserName(results.getString("username"));
        user.setId(results.getInt("Id"));
        user.setEmail(results.getDate("email"));

        return user;
    }
}
