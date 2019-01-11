package model.dao.impl;

import controller.command.BuyTicketCommand;
import model.dao.TicketDao;
import model.entity.Ticket;
import org.apache.log4j.Logger;
import util.QueryBundle;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.List;

public class JDBCTicketDao implements TicketDao {
    public static final Logger LOG = Logger.getLogger(JDBCTicketDao.class);

    private DataSource dataSource;

    public JDBCTicketDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public Integer create(Ticket entity) {
        return null;
    }

    @Override
    public Ticket findById(int id) {
        return null;
    }

    @Override
    public List<Ticket> findAll() {
        return null;
    }

    @Override
    public void update(Ticket entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Ticket buyTicket(Integer exhibitionId, Integer userId) {
        LOG.debug(MessageFormat.format("Start buy ticket on Exhibition ''{0}'' for user ''{1}''", exhibitionId, userId));
        Ticket ticket = new Ticket();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(QueryBundle.getProperty("select.tickets.which.not.bought"));
             PreparedStatement ps1 = connection.prepareStatement(QueryBundle.getProperty("update.buy.ticket"));
             PreparedStatement ps2 = connection.prepareStatement(QueryBundle.getProperty("select.wishlist.byExhib.and.userId"))) {
            connection.setAutoCommit(false);
            ps.setInt(1, exhibitionId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ps2.setInt(1, userId);
                ps2.setInt(2, exhibitionId);
                ResultSet rs2 = ps2.executeQuery();
                if (rs2.next()) {
                    LOG.debug(MessageFormat.format("Duy Ticket for request id ''{0}''", rs2.getInt("id")));
                    ticket.setRequestId(rs2.getInt("id"));
                    ps1.setInt(1, rs2.getInt("id"));
                    ps1.setInt(2, exhibitionId);
                }
                Integer success = ps1.executeUpdate();
                if (success == 1) {
                    connection.commit();
                } else {
                    connection.rollback();
                }
            }
        } catch (SQLException e) {
            LOG.error("", e);
        }
        return ticket;
    }

    @Override
    public void createTickets(Integer exhibitionId, Integer count) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(QueryBundle.getProperty("insert.ticket"))) {
            for (int i = 0; i < count; i++) {
                ps.setInt(1, exhibitionId);
                ps.addBatch();
            }
            ps.executeBatch();
        } catch (SQLException e) {
            LOG.error("", e);
        }
    }
}
