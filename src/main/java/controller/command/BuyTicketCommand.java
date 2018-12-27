package controller.command;

import service.TicketService;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public class BuyTicketCommand implements Command{

    private TicketService ticketService;

    public BuyTicketCommand(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Override
    public String execute(HttpServletRequest request) throws ParseException {

        ticketService.buyTicket(
                Integer.parseInt(request.getParameter("exhibitionId")),
                Integer.parseInt(request.getParameter("requestId")));

        return "/WEB-INF/user/user.jsp";
    }
}
