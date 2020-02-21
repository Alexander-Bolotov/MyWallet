package MyWallet.domain.service;

import MyWallet.domain.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;


import java.util.List;

public interface UserService  extends UserDetailsService {


    List<User> getListUsers();

    void addUser(User user);

    User getUserById(Long id);

    void deleteUserById(Long id);

    User getUser(String name);

    boolean userIsExist(User user);

    boolean nameIsExist(String name);
}
