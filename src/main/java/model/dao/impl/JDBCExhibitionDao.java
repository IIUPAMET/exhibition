package model.dao.impl;

import com.mysql.jdbc.Statement;
import model.dao.ExhibitionDao;
import model.dao.mapper.ExhibitionMapper;
import model.entity.Exhibition;
import org.apache.log4j.Logger;
import util.QueryBundle;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class JDBCExhibitionDao implements ExhibitionDao {
    private static Logger LOG = Logger.getLogger(ExhibitionDao.class);
    private DataSource dataSource;

    private static int noOfRecords;

    public JDBCExhibitionDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Integer create(Exhibition entity) {
        LOG.debug("Create Exhibition DaoMethod");
        try (Connection connection = dataSource.getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement ps = connection.prepareStatement(QueryBundle.getProperty("insert.exhibition"), Statement.RETURN_GENERATED_KEYS);) {
            ps.setString(1, entity.getName());
            ps.setDate(2, java.sql.Date.valueOf(entity.getStartDate()));
            ps.setDate(3, java.sql.Date.valueOf(entity.getEndDate()));
            ps.setString(4, entity.getThema());
            ps.setString(5, entity.getAuthor());
            ps.executeUpdate();
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    LOG.debug(MessageFormat.format("Exhibition successful created ''{0}''", entity.toString()));
                    connection.commit();
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            connection.rollback();
            LOG.error("", e);
        }
        connection.setAutoCommit(true);
        } catch (SQLException e) {
            LOG.error("", e);
        }
        return null;
    }

    @Override
    public Exhibition findById(int id) {
        Exhibition result = new Exhibition();
        try (Connection connection = dataSource.getConnection()) {
            connection.setAutoCommit(false);
            try ( PreparedStatement ps = connection.prepareStatement(QueryBundle.getProperty("select.exhibition.all"))) {
            ResultSet rs = ps.executeQuery();
            ExhibitionMapper mapper = new ExhibitionMapper();
            if (rs.next()) {
                result = mapper.extractFromResultSet(rs);
            }
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            LOG.error("", e);
        }
        connection.setAutoCommit(true);
        } catch (SQLException e) {
            LOG.error("", e);
        }
        return result;
    }

    public List<Exhibition> getExhibitionForUser(Integer userId) {
        List<Exhibition> result = new ArrayList<>();
        LOG.debug("Exhibition for User Dao Method");
        try (Connection connection = dataSource.getConnection()) {
        connection.setAutoCommit(false);
        try ( PreparedStatement ps = connection.prepareStatement(QueryBundle.getProperty("select.exhibition.for.user"))) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            ExhibitionMapper mapper = new ExhibitionMapper();
            while (rs.next()) {
                result.add(mapper.extractFromResultSet(rs));
            }
            LOG.debug(MessageFormat.format("Count of Exhibitions for user ''{0}''", result.size()));
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            LOG.error("", e);
        }
        connection.setAutoCommit(true);
        } catch (SQLException e) {
            LOG.error("", e);
        }
        return result;
    }

    @Override
    public List<Exhibition> viewAllExhibition(Integer offset, Integer noOfRecords) {
        LOG.debug("View all Exhibition DaoMethod");
        String query = "select SQL_CALC_FOUND_ROWS * from exhibition_event limit "
                + offset + ", " + noOfRecords;
        List<Exhibition> result = new ArrayList<>();
        ExhibitionMapper mapper = new ExhibitionMapper();
        try (Connection connection = dataSource.getConnection()) {
        connection.setAutoCommit(false);
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(mapper.extractFromResultSet(rs));
            }
            rs.close();
            rs = ps.executeQuery("SELECT FOUND_ROWS()");
            if (rs.next()) {
                this.noOfRecords = rs.getInt(1);
            }
            LOG.debug(MessageFormat.format("Count of Exhibitions for user ''{0}''", result.size()));

            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            LOG.error("", e);
        }
        connection.setAutoCommit(true);
        } catch (SQLException e) {
            LOG.error("", e);
        }

        return result;
    }

    public static int getNoOfRecords() {
        return noOfRecords;
    }

    @Override
    public List<Exhibition> findAll() {
        List<Exhibition> result = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
        connection.setAutoCommit(false);
        try (PreparedStatement ps = connection.prepareStatement(QueryBundle.getProperty("select.exhibition.all"))) {
            ResultSet rs = ps.executeQuery();
            ExhibitionMapper mapper = new ExhibitionMapper();
            while (rs.next()) {
                result.add(mapper.extractFromResultSet(rs));
            }
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            LOG.error("", e);
        }
        connection.setAutoCommit(true);
        } catch (SQLException e) {
            LOG.error("", e);
        }
        return result;
    }

    @Override
    public void update(Exhibition entity) {

    }

    @Override
    public void delete(int id) {

    }
}
