package service;

import model.dao.ExhibitionDao;
import model.entity.Exhibition;

import java.time.LocalDate;
import java.util.List;

public class ExhibitionSeviceImpl implements ExhibitionService {
    ExhibitionDao exhibitionDao;
    public ExhibitionSeviceImpl(ExhibitionDao exhibitionDao) {
        this.exhibitionDao = exhibitionDao;
    }

    @Override
    public List<Exhibition> getAll() {
        return exhibitionDao.findAll();
    }
    @Override
    public void crateExhibition(String name, LocalDate start, LocalDate end, String theme, String author){

        Exhibition exhibition = new Exhibition();
        exhibition.setName(name);
        exhibition.setEndDate(end);
        exhibition.setStartDate(start);
        exhibition.setAuthor(author);
        exhibition.setThema(theme);
            exhibitionDao.create(exhibition);
    }

    @Override
    public void exhibitionWithTickets(String name, LocalDate start, LocalDate end, String theme, String author, Integer numOfTickets) {
        Exhibition exhibition = new Exhibition();
        exhibition.setName(name);
        exhibition.setEndDate(end);
        exhibition.setStartDate(start);
        exhibition.setAuthor(author);
        exhibition.setThema(theme);
            exhibitionDao.exhibitionWithTickets(exhibition, numOfTickets);
    }
}
