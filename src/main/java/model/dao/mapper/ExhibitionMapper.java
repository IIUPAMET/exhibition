package model.dao.mapper;

import controller.command.BuyTicketCommand;
import model.entity.Exhibition;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class ExhibitionMapper implements ObjectMapper<Exhibition> {
    public static final Logger LOG = Logger.getLogger(BuyTicketCommand.class);
    @Override
    public Exhibition extractFromResultSet(ResultSet rs) throws SQLException {
        Exhibition exhibition = new Exhibition();
        exhibition.setId(rs.getInt("id"));
        exhibition.setName(rs.getString("exhibition_name"));
        exhibition.setEndDate(rs.getDate("end_date").toLocalDate());
        exhibition.setStartDate(rs.getDate("start_date").toLocalDate());
        exhibition.setAuthor(rs.getString("author"));
        exhibition.setThema(rs.getString("thema"));
        return exhibition;
    }

    @Override
    public Exhibition makeUnique(Map<Integer, Exhibition> cache, Exhibition teacher) {
        return null;
    }
}
