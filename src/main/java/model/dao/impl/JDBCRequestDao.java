package model.dao.impl;

import controller.command.BuyTicketCommand;
import model.dao.RequestDao;
import model.entity.Request;
import org.apache.log4j.Logger;
import util.QueryBundle;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.*;

public class JDBCRequestDao implements RequestDao {
    public static final Logger LOG = Logger.getLogger(JDBCRequestDao.class);
    private DataSource dataSource;

    public JDBCRequestDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Map<Integer, Integer> getWithListByUserId(int userId) {
        LOG.debug(MessageFormat.format("Get Wishes for user with id ''{0}''", userId));

        Map<Integer, Integer> wishMap = new HashMap<>();
        try (Connection connection = dataSource.getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement psExhibition = connection.prepareStatement(QueryBundle.getProperty("select.wishlist"))) {
                psExhibition.setInt(1, userId);
                ResultSet rs = psExhibition.executeQuery();
                while (rs.next()) {
                    wishMap.put(rs.getInt("exhibition_event_id"), rs.getInt("exhibition_event_id"));
                }
                LOG.debug(MessageFormat.format("Count of exhibition form this user wishes ''{0}''", wishMap.size()));
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                LOG.error("", e);
            }
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            LOG.error("", e);
        }
        return wishMap;
    }

    @Override
    public Integer create(Request entity) {
        return null;
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

}
