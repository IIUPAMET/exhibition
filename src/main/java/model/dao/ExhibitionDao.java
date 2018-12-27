package model.dao;

import model.entity.Exhibition;

import java.time.LocalDate;
import java.util.List;

public interface ExhibitionDao extends GenericDao<Exhibition> {
    void crateExhibition(String name, LocalDate start, LocalDate end, String theme, String author, String description);
    void exhibitionWithTickets(Exhibition exhibition, Integer numOfTickets);
    List<Exhibition> getExhibitionForUser(Integer userId);
}
