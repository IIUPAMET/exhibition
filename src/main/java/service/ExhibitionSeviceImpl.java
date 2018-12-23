package service;

import model.dao.ExhibitionDao;
import model.dao.impl.DaoFactory;
import model.dao.impl.JDBCDaoFactory;
import model.entity.Exhibition;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class ExhibitionSeviceImpl implements ExhibitionService {

    private DaoFactory daoFactory = JDBCDaoFactory.getInstance();

    @Override
    public List<Exhibition> getAll() {
        try (ExhibitionDao dao = daoFactory.createExhibitionDao()) {
        return dao.findAll();
    }
    }
    @Override
    public void crateExhibition(String name, LocalDate start, LocalDate end, String theme, String author){

        Exhibition exhibition = new Exhibition();
        exhibition.setName(name);
        exhibition.setEndDate(end);
        exhibition.setStartDate(start);
        exhibition.setAuthor(author);
        exhibition.setThema(theme);
        try (ExhibitionDao dao = daoFactory.createExhibitionDao()) {
            dao.create(exhibition);
        }
    }

    @Override
    public void exhibitionWithTickets(String name, LocalDate start, LocalDate end, String theme, String author, Integer numOfTickets) {
        Exhibition exhibition = new Exhibition();
        exhibition.setName(name);
        exhibition.setEndDate(end);
        exhibition.setStartDate(start);
        exhibition.setAuthor(author);
        exhibition.setThema(theme);
        try (ExhibitionDao dao = daoFactory.createExhibitionDao()) {
            dao.exhibitionWithTickets(exhibition, numOfTickets);
        }
    }
}
