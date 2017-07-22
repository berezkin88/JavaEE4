package crud.dao;

import crud.model.User;

import java.util.List;

/**
 * Created by Alexander on 22/07/2017.
 */
public interface UserDao {

    void addUser(User user);

    List<User> listUsers();

    void update(User user);

    void delete(User user);

    User findUserById(Integer id);
}
