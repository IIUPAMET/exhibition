package service;

import model.dao.UserDao;
import model.dao.impl.JDBCUserDao;
import model.entity.User;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;

public class UserServiceTest {
    @Test
    public void createUser() {
        User user = new User();
        JDBCUserDao userDao = Mockito.mock(JDBCUserDao.class);
        Mockito.doNothing().when(userDao).create(user);

        UserService userService = new UserServiceImpl(userDao);

        userService.create(user);

        Mockito.verify(userDao, times(1)).create(user);
    }
}
