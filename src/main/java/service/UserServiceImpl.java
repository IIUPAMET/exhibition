package service;

import model.dao.UserDao;
import model.entity.User;
import org.apache.log4j.Logger;

import java.text.MessageFormat;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    public static final Logger LOG = Logger.getLogger(UserServiceImpl.class);

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Optional<User> login(String login, String pass) {
        Optional<User> result;
        result = userDao.login(login, pass);
        if(!result.isPresent())
            throw new RuntimeException("User not found");
        return result;
    }

    @Override
    public User create(String login, String pass, String ukrName, String engname, String email) {
        User user = new User();
        user.setPass(pass);
        user.setLogin(login);
        user.setMail(email);
        user.setNameEN(engname);
        user.setNameUA(ukrName);
        user.setRole(User.Role.USER);

        userDao.create(user);
        return null;
    }

    @Override
    public void addWish(Integer user_id, Integer exhib_id) {
        if(LOG.isDebugEnabled())
            LOG.debug(MessageFormat.format("Start User[{0}] add wish for Exhibition[{1}]", user_id, exhib_id));
        userDao.addWish(user_id, exhib_id);
    }
}
