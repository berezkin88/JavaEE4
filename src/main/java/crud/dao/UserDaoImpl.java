package crud.dao;

import crud.model.User;
import org.hibernate.SessionFactory;

/**
 * Created by Alexander on 30/07/2017.
 */
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    @Override
    public User findUserById(Integer id) {
        return sessionFactory.getCurrentSession().load(User.class, id);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
