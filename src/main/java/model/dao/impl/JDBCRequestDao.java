package model.dao.impl;

import com.mysql.jdbc.Statement;
import model.dao.RequestDao;
import model.entity.Request;
import util.QueryBundle;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class JDBCRequestDao implements RequestDao {
    DataSource dataSource;

    public JDBCRequestDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void create(Request entity) {

    }

    @Override
    public Request findById(int id) {
        return null;
    }

    @Override
    public List<Request> findAll() {
        return null;
    }

    @Override
    public void update(Request entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Map<Integer, Integer> getWithListByUserId(int userId) {
        Map<Integer, Integer> wishMap = new HashMap<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement psExhibition = connection.prepareStatement(QueryBundle.getProperty("select.wishlist"))
        ) {
            psExhibition.setInt(1, userId);
            ResultSet rs = psExhibition.executeQuery();
            while (rs.next()) {
                wishMap.put(rs.getInt("exhibition_event_id"),rs.getInt("exhibition_event_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wishMap;
    }
}
