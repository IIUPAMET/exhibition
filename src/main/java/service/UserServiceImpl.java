package service;

import model.dao.impl.*;
import model.dao.UserDao;
import model.entity.User;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUsers() {
            return userDao.findAll();
    }

    @Override
    public Optional<User> login(String login, String pass) {
        Optional<User> result; //= Optional.empty();
            result = userDao.login(login, pass);
        return result;
    }

    @Override
    public User create(User user) {
            userDao.create(user);
        return null;
    }

    @Override
    public User create(String login, String pass, String ukrname, String engname, String email) {
        User user = new User();
        user.setPass(pass);
        user.setLogin(login);
        user.setMail(email);
        user.setNameEN(engname);
        user.setNameUA(ukrname);
        user.setRole(User.Role.USER);
            userDao.create(user);
        return null;
    }

    @Override
    public void addwish(Integer user_id, Integer exhib_id) {
            userDao.addwish(user_id, exhib_id);

    }


}
