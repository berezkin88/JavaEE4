package crud.dao;

import crud.model.User;
import org.hibernate.SessionFactory;

/**
 * Created by Alexander on 30/07/2017.
 */
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    @Override
    public User findByUsername(String username) {
        return (User) sessionFactory.getCurrentSession().createQuery("select u from User u where u.username like :username").
                setParameter("username", username).uniqueResult();
    }

    @Override
    public void save(User user) {
            sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public User findUserById(Integer id) {
        return sessionFactory.getCurrentSession().load(User.class, id);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
