package crud.dao;

import crud.model.User;

import java.util.List;

/**
 * Created by Alexander on 22/07/2017.
 */
public interface UserDao {

    User findUserById(Integer id);
}
