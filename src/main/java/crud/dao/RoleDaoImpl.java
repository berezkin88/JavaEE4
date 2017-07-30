package crud.dao;

import crud.model.Role;
import org.hibernate.SessionFactory;

/**
 * Created by Alexander on 30/07/2017.
 */
public class RoleDaoImpl implements RoleDao {

    private SessionFactory sessionFactory;

    @Override
    public Role findRoleById(Integer id) {
        return sessionFactory.getCurrentSession().load(Role.class, id);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
