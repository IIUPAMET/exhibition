package model.dao.impl;

import model.dao.ExhibitionDao;
import model.dao.mapper.ExhibitionMapper;
import model.entity.Exhibition;
import util.QueryBundle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCExhibitionDao implements ExhibitionDao {
    private Connection connection;

    public JDBCExhibitionDao(Connection connection){
        this.connection = connection;
    }


    @Override
    public void create(Exhibition entity) {

    }

    @Override
    public Exhibition findById(int id) {
        Exhibition result = new Exhibition();
        try(PreparedStatement ps = connection.prepareStatement(QueryBundle.getProperty("select.exhibition.all"))) {
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
        try(PreparedStatement ps = connection.prepareStatement(QueryBundle.getProperty("select.exhibition.all"))) {
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

    @Override
    public void close() {

    }
}
