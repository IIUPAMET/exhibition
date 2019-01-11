package service;

import controller.command.BuyTicketCommand;
import model.dao.ExhibitionDao;
import model.dao.TicketDao;
import model.entity.Exhibition;
import org.apache.log4j.Logger;

import java.time.LocalDate;
import java.util.List;

public class ExhibitionSeviceImpl implements ExhibitionService {
    public static final Logger LOG = Logger.getLogger(BuyTicketCommand.class);
    private ExhibitionDao exhibitionDao;
    private TicketDao ticketDao;

    public ExhibitionSeviceImpl(ExhibitionDao exhibitionDao,TicketDao ticketDao) {
        this.exhibitionDao = exhibitionDao;
        this.ticketDao = ticketDao;
    }

    @Override
    public List<Exhibition> getAll() {
        return exhibitionDao.findAll();
    }

    @Override
    public List<Exhibition> viewAllExhibition(Integer offset, Integer noOfRecords) {
        return exhibitionDao.viewAllExhibition(offset, noOfRecords);
    }

    public List<Exhibition> getExhibitionForUser(Integer userId){
        return exhibitionDao.getExhibitionForUser(userId);
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

       Integer exhibitionId = exhibitionDao.create(exhibition);
       ticketDao.createTickets(exhibitionId, numOfTickets);
    }
}
