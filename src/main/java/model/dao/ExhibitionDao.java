package model.dao;

import model.entity.Exhibition;

import java.time.LocalDate;
import java.util.Date;

public interface ExhibitionDao extends GenericDao<Exhibition> {
    public void crateExhibition(String name, LocalDate start, LocalDate end, String theme, String author, String description);
    public void exhibitionWithTickets(Exhibition exhibition, Integer numOfTickets);
}
