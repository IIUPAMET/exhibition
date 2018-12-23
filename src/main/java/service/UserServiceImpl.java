package service;

import model.dao.impl.*;
import model.dao.UserDao;
import model.entity.User;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private DaoFactory daoFactory = JDBCDaoFactory.getInstance();

    @Override
    public List<User> getAllUsers() {
        try (UserDao dao = daoFactory.createUserDao()) {
            return dao.findAll();
        }
    }

    @Override
    public Optional<User> login(String login, String pass) {
        Optional<User> result; //= Optional.empty();
        try (UserDao userDao = daoFactory.createUserDao()) {
            result = userDao.login(login, pass);
        }
        return result;
    }

    @Override
    public User create(User user) {
        try (UserDao userDao = daoFactory.createUserDao()) {
            userDao.create(user);
        }
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
        try (UserDao userDao = daoFactory.createUserDao()) {
            userDao.create(user);
        }
        return null;
    }

    @Override
    public void addwish(Integer user_id, Integer exhib_id) {
        try (UserDao userDao = daoFactory.createUserDao()) {
            userDao.addwish(user_id, exhib_id);
        }
    }


}
