package service;

import controller.command.BuyTicketCommand;
import model.dao.TicketDao;
import model.entity.Exhibition;
import model.entity.Ticket;
import org.apache.log4j.Logger;

public class TicketService {
    public static final Logger LOG = Logger.getLogger(BuyTicketCommand.class);
    private TicketDao ticketDao;

    public TicketService(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    public Ticket buyTicket(Integer exhibitionId, Integer userId){
        return ticketDao.buyTicket(exhibitionId, userId);
    }
}
