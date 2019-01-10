package model.dao.impl;

import model.dao.TicketDao;
import model.entity.Ticket;
import util.QueryBundle;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JDBCTicketDao implements TicketDao {

    private DataSource dataSource;

    public JDBCTicketDao(DataSource dataSource){
        this.dataSource = dataSource;
    }


    @Override
    public void create(Ticket entity) {

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
        try(Connection connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(QueryBundle.getProperty("select.tickets.which.not.bought"));
            PreparedStatement ps1 = connection.prepareStatement(QueryBundle.getProperty("update.buy.ticket"));
            PreparedStatement ps2 = connection.prepareStatement(QueryBundle.getProperty("select.wishlist.byExhib.and.userId"))) {
            connection.setAutoCommit(false);
            ps.setInt(1, exhibitionId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                ps2.setInt(1,userId);
                ps2.setInt(2,exhibitionId);
                ResultSet rs2 = ps2.executeQuery();
                if(rs2.next())
                ps1.setInt(1,rs2.getInt("id"));
                ps1.setInt(2,rs.getInt("id"));
                Integer success = ps1.executeUpdate();
                if(success == 1){
                    connection.commit();
                }else{
                    connection.rollback();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
