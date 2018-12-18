package persistence;
import entity.Location;
import entity.Message;
import entity.Trip;
import entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.*;
import java.util.List;


/**
 * The type Location dao.
 */
public class GenericDao<T> {
    private Class<T> type;
    private Session session;
    private Transaction transaction;
    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * Instantiates a new Generic dao
     *
     * @param type the entity type
     */
    public GenericDao(Class<T> type){
        this.type = type;
    }

    private Session getSession(){
        return SessionFactoryProvider.getSessionFactory().openSession();
    }




    public List<T> getAll() {

        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        List<T> entities = session.createQuery(query).getResultList();
        session.close();
        return entities;

    }

    public T getById(int id) {
        Session session = getSession();
        T entity = (T)session.get(type, id);
        session.close();
        return entity;
    }

    /**
     * Get objects by property (exact match)
     * sample usage: getByPropertyEqual("lastname", "Curry")
     */
    public List<T> getByPropertyEqual(String propertyName, String value) {
        session = getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<T> list = session.createQuery( query ).getResultList();
        session.close();
        return list;
    }

    public List<Trip> getByCreator(User user){
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Trip> query = builder.createQuery(Trip.class);
        Root<Trip> root = query.from(Trip.class);
        Expression<String> propertyPath = root.get("tripCreator");
        query.where(builder.equal(propertyPath, user));
        List<Trip> trips = session.createQuery(query).getResultList();
        session.close();
        return trips;
    }

    public List<Message> getMostRecentTen(Trip theTrip){


        Session session = getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<Message> query = builder.createQuery(Message.class);
                //session.createQuery(query).orderBy("sentDateTime").setMaxResults(10);
        Root<Message> root = query.from(Message.class);
        query.select(root).orderBy(builder.asc(root.get("sentDateTime")));
        Expression<String> propertyPath = root.get("trip");
        query.where(builder.equal(propertyPath, theTrip ));
        List<Message> messages = session.createQuery(query).setMaxResults(8).getResultList();
        session.close();
        return messages;

    }

    /**
     /**
     * Update an BusinessEntity
     *
     * @param entity BusinessEntity to be inserted or updated
     */
    public void saveOrUpdate(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(entity);
        transaction.commit();
        session.close();
    }

    public void delete (T entity){
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }
    /**
     * update user
     * @param entity  User to be inserted or updated
     */
    public int insert(T entity) {
        int id = 0;
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(entity);
        transaction.commit();
        session.close();
        return id;
    }


}