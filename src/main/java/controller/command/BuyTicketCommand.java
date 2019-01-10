package controller.command;

import model.entity.User;
import service.TicketService;

import javax.servlet.http.HttpServletRequest;

public class BuyTicketCommand implements Command{

    private TicketService ticketService;

    public BuyTicketCommand(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Override
    public String execute(HttpServletRequest request){


        ticketService.buyTicket(
                Integer.parseInt(request.getParameter("exhibitionId")),
                ((User)request.getSession().getAttribute("user")).getId());

        return "redirect: home";
    }
}
