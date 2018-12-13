package model.dao.impl;

import model.dao.UserDao;
import model.dao.mapper.UserMapper;
import model.entity.User;
import util.QueryBundle;

import java.sql.*;
import java.util.List;

public class JDBCUserDao implements UserDao {
    private Connection connection;

    public JDBCUserDao(Connection connection){
        this.connection = connection;
    }

    @Override
    public void create(User entity) {
        try (PreparedStatement ps = connection.prepareStatement(QueryBundle.getProperty("insert.user"))) {
            ps.setString(1, entity.getLogin());
            ps.setString(2, entity.getPass());
            ps.setString(3, entity.getMail());
            ps.setString(4, entity.getNameEN());
            ps.setString(5, entity.getNameUA());
            ps.setString(6, entity.getRole().name());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findById(int id) {
        User result = new User();
        UserMapper mapper = new UserMapper();
        try (PreparedStatement ps = connection.prepareStatement(QueryBundle.getProperty("select.user.byId"))) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = mapper.extractFromResultSet(rs);
            }
            System.out.println(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(int id) {

    }
    @Override
    public User login(String login, String pass) {
        User result = new User();
        UserMapper mapper = new UserMapper();
        try (PreparedStatement ps = connection.prepareStatement(QueryBundle.getProperty("select.user.login"))) {
            ps.setString(1, login);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = mapper.extractFromResultSet(rs);
            }
            System.out.println(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
