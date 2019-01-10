package service;

import model.dao.TicketDao;
import model.entity.Ticket;

public class TicketService {

    TicketDao ticketDao;

    public TicketService(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    public Ticket buyTicket(Integer exhibitionId, Integer userId){

        ticketDao.buyTicket(exhibitionId, userId);

        return null;
    }
}
