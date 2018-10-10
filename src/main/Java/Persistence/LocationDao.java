package Persistence;
import Entity.Location;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.*;
import java.util.List;


public class LocationDao {
    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();


    public List<Location> getAllLocations() {

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Location> query = builder.createQuery(Location.class);
        Root<Location> root = query.from(Location.class);
        List<Location> locations = session.createQuery(query).getResultList();
        session.close();
        return locations;

    }

    public Location getById(int Id) {
        Session session = sessionFactory.openSession();
        Location location = session.get(Location.class, Id);
        session.close();
        return location;
    }

    /**
     * Delete a location
     * @param location to be deleted
     */
    public void delete(Location location){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(location);
        transaction.commit();
        session.close();
    }

    /**
     * update location
     * @param location  Location to be inserted or updated
     */
    public int insert(Location location) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(location);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * update location
     * @param location  Location to be inserted or updated
     */
    public void saveOrUpdate(Location location) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(location);
        transaction.commit();
        session.close();
    }
}
