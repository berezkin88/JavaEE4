package crud.service;

/**
 * Created by Alexander on 30/07/2017.
 */
public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
