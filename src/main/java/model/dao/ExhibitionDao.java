package model.dao;

import model.entity.Exhibition;

import java.time.LocalDate;
import java.util.List;

public interface ExhibitionDao extends GenericDao<Exhibition> {
    List<Exhibition> getExhibitionForUser(Integer userId);
    List<Exhibition> viewAllExhibition(Integer offset, Integer noOfRecords);
}
