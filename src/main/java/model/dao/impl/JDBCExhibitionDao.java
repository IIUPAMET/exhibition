package model.dao.impl;

import com.mysql.jdbc.Statement;
import model.dao.ExhibitionDao;
import model.dao.mapper.ExhibitionMapper;
import model.entity.Exhibition;
import util.QueryBundle;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JDBCExhibitionDao implements ExhibitionDao {
    private DataSource dataSource;

    public JDBCExhibitionDao(DataSource dataSource){
        this.dataSource = dataSource;
    }


    @Override
    public void create(Exhibition entity) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(QueryBundle.getProperty("insert.exhibition"))) {
            ps.setString(1, entity.getName());
            ps.setDate(2, java.sql.Date.valueOf(entity.getStartDate()));
            ps.setDate(3, java.sql.Date.valueOf(entity.getEndDate()));
            ps.setString(4, entity.getThema());
            ps.setString(5, entity.getAuthor());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void crateExhibition(String name, LocalDate start, LocalDate end, String theme, String author, String description){

    }

    @Override
    public void exhibitionWithTickets(Exhibition entity, Integer numOfTickets) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement psExhibition = connection.prepareStatement(QueryBundle.getProperty("insert.exhibition"), Statement.RETURN_GENERATED_KEYS);
             PreparedStatement psTicket = connection.prepareStatement(QueryBundle.getProperty("insert.ticket"));
        ) {
            psExhibition.setString(1, entity.getName());
            psExhibition.setDate(2, java.sql.Date.valueOf(entity.getStartDate()));
            psExhibition.setDate(3, java.sql.Date.valueOf(entity.getEndDate()));
            psExhibition.setString(4, entity.getThema());
            psExhibition.setString(5, entity.getAuthor());
            psExhibition.executeUpdate();
            try (ResultSet generatedKeys = psExhibition.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    entity.setId(generatedKeys.getInt(1));
                }
                else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
            for(int i=0; i < numOfTickets; i++){
                psTicket.setInt(1, entity.getId());
                psTicket.addBatch();
            }
            psTicket.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Exhibition findById(int id) {
        Exhibition result = new Exhibition();
        try(Connection connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(QueryBundle.getProperty("select.exhibition.all"))) {
            ResultSet rs = ps.executeQuery();
            ExhibitionMapper mapper = new ExhibitionMapper();
            if (rs.next()) {
                result = mapper.extractFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Exhibition> findAll() {
        List<Exhibition> result = new ArrayList<>();
        try(Connection connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(QueryBundle.getProperty("select.exhibition.all"))) {
            ResultSet rs = ps.executeQuery();
            ExhibitionMapper mapper = new ExhibitionMapper();
            while (rs.next()) {
                result.add(mapper.extractFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
