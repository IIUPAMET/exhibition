package model.dao.mapper;

import model.entity.Exhibition;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class ExhibitionMapper implements ObjectMapper<Exhibition> {
    @Override
    public Exhibition extractFromResultSet(ResultSet rs) throws SQLException {
        Exhibition exhibition = new Exhibition();
        exhibition.setId(rs.getInt("id"));
        exhibition.setName(rs.getString("exhibition_name"));
        exhibition.setEndDate(rs.getDate("end_date"));
        exhibition.setStartDate(rs.getDate("start_date"));
        exhibition.setAuthor(rs.getString("author"));
        exhibition.setThema(rs.getString("thema"));
        return exhibition;
    }

    @Override
    public Exhibition makeUnique(Map<Integer, Exhibition> cache, Exhibition teacher) {
        return null;
    }
}
