package service;

import model.entity.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();

    User login(String login, String pass);

    User create(User user);

    User create(String login, String pass, String ukrname, String engname, String email);

}
