package crud.service;

import crud.model.User;

/**
 * Created by Alexander on 30/07/2017.
 */
public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
