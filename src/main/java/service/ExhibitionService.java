package service;

import model.entity.Exhibition;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ExhibitionService {
    List<Exhibition> getAll();
    public void crateExhibition(String name, LocalDate start, LocalDate end, String theme, String author);
}
