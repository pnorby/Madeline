package Persistence;

import Entity.Trip;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


public class TripDao {
    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();


    public List<Trip> getAllTrips() {

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Trip> query = builder.createQuery(Trip.class);
        Root<Trip> root = query.from(Trip.class);
        List<Trip> trips = session.createQuery(query).getResultList();
        session.close();
        return trips;

    }

    public Trip getById(int id) {
        Session session = sessionFactory.openSession();
        Trip trip = session.get(Trip.class, id);
        session.close();
        return trip;
    }

    /**
     * Delete a trip
     * @param trip to be deleted
     */
    public void delete(Trip trip){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(trip);
        transaction.commit();
        session.close();
    }

    /**
     * update trip
     * @param trip  Trip to be inserted or updated
     */
    public int insert(Trip trip) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(trip);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * update trip
     * @param trip  Trip to be inserted or updated
     */
    public void saveOrUpdate(Trip trip) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(trip);
        transaction.commit();
        session.close();
    }
}
