package crud.service;

import crud.dao.RoleDao;
import crud.dao.UserDao;
import crud.model.Role;
import crud.model.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Alexander on 30/07/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    private RoleDao roleDao;

    private UserDao userDao;

    @Override
    @Transactional
    public void save(User user) {
        user.setPassword(user.getPassword());
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.findRoleById(1));
        user.setRoles(roles);
        userDao.save(user);
    }

    @Override
    @Transactional
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
