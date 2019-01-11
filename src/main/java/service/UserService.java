package service;

import model.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> login(String login, String pass);

    User create(String login, String pass, String ukrname, String engname, String email);

    void addWish(Integer user_id, Integer exhib_id);
}
