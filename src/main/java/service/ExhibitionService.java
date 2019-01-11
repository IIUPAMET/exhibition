package service;

import model.entity.Exhibition;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ExhibitionService {
    List<Exhibition> viewAllExhibition(Integer offset, Integer noOfRecords);
    List<Exhibition> getExhibitionForUser(Integer userId);
    List<Exhibition> getAll();
    void crateExhibition(String name, LocalDate start, LocalDate end, String theme, String author);
    void exhibitionWithTickets(String name, LocalDate start, LocalDate end, String theme, String author, Integer numOfTickets);
}
