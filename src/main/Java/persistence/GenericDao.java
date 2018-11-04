package persistence;
import entity.Location;
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




    public List<T> getAll(T entity) {

        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        List<T> users = session.createQuery(query).getResultList();
        session.close();
        return users;

    }

    public <T>T getById(int Id) {
        Session session = getSession();
        T entity = (T)session.get(type, Id);
        session.close();
        return entity;
    }

    public List<User> getByUsername(String value){
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        Expression<String> propertyPath = root.get("userName");
        query.where(builder.equal(propertyPath, value ));
        List<User> users = session.createQuery(query).getResultList();
        session.close();
        return users;
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