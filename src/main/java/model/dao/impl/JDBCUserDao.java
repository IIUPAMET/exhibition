package model.dao.impl;

import model.dao.UserDao;
import model.dao.mapper.UserMapper;
import model.entity.User;
import util.QueryBundle;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;
import java.util.Optional;

public class JDBCUserDao implements UserDao {
    private DataSource dataSource;

    public JDBCUserDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void create(User entity) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(QueryBundle.getProperty("insert.user"))) {
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
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(QueryBundle.getProperty("select.user.byId"))) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = mapper.extractFromResultSet(rs);
            }
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
    public Optional<User> login(String login, String pass) {
        Optional<User> result = Optional.empty();
        UserMapper mapper = new UserMapper();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(QueryBundle.getProperty("select.user.login"))) {
            ps.setString(1, login);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = Optional.of(mapper.extractFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void addwish(Integer user_id, Integer exhib_id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(QueryBundle.getProperty("insert.addwish"))) {
            ps.setInt(1, user_id);
            ps.setInt(2, exhib_id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
