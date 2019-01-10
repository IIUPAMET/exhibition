package model.dao;

import model.entity.Exhibition;
import model.entity.Ticket;

public interface TicketDao extends GenericDao<Ticket> {
    Ticket buyTicket(Integer exhibitionId, Integer userId);
}
