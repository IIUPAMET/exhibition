package model.dao;

import model.entity.User;

import java.util.Optional;

public interface UserDao extends GenericDao<User> {
    Optional<User> login(String login, String pass);

    void addwish(Integer user_id, Integer exhib_id);
}
