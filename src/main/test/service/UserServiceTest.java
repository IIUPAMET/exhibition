package service;

import model.dao.impl.JDBCUserDao;
import model.entity.User;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.mockito.Mockito.times;

public class UserServiceTest {
    @Test
    public void createUser() {
        JDBCUserDao userDao = Mockito.mock(JDBCUserDao.class);

        UserService userService = new UserServiceImpl(userDao);
        userService.create("login", "pass", "ukrname", "engname", "my@mail.com");

        Mockito.verify(userDao, times(1)).create(Mockito.any());
    }

    @Test(expected = RuntimeException.class)
    public void loginWithWrongUserPassword() {
        JDBCUserDao userDao = Mockito.mock(JDBCUserDao.class);
        Mockito.when(userDao.login(Mockito.any(), Mockito.any())).thenReturn(Optional.empty());

        UserService userService = new UserServiceImpl(userDao);
        userService.login("vasya", "pupkin");
    }

    @Test
    public void loginWithUserPassword() {
        JDBCUserDao userDao = Mockito.mock(JDBCUserDao.class);
        Mockito.when(userDao.login(Mockito.any(), Mockito.any())).thenReturn(Optional.of(Mockito.mock(User.class)));

        UserService userService = new UserServiceImpl(userDao);
        userService.login("vasya", "pupkin");
    }
}
