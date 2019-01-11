package service;

import model.dao.ExhibitionDao;
import model.dao.TicketDao;
import org.junit.Test;
import org.mockito.Mockito;


import java.time.LocalDate;

import static org.mockito.Mockito.times;

public class ExhibitionServiceTest {
    @Test
    public void createExhibitionWithTickets() {
        ExhibitionDao exhibitionDao = Mockito.mock(ExhibitionDao.class);
        TicketDao ticketDao = Mockito.mock(TicketDao.class);

        ExhibitionService exhibitionService = new ExhibitionSeviceImpl(exhibitionDao, ticketDao);
        exhibitionService.exhibitionWithTickets("Name", LocalDate.now(),LocalDate.now(),"theme", "Author", 5);
        Mockito.verify(exhibitionDao, times(1)).create(Mockito.any());
     //   Mockito.verify(ticketDao, times(1)).createTickets(Mockito.any(), Mockito.any());
        Mockito.verify(ticketDao, times(0)).create(Mockito.any());
    }
}
