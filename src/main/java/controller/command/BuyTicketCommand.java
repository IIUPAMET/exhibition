package controller.command;

import model.entity.User;
import org.apache.log4j.Logger;
import service.TicketService;

import javax.servlet.http.HttpServletRequest;

public class BuyTicketCommand implements Command {
    public static final Logger LOG = Logger.getLogger(BuyTicketCommand.class);
    private TicketService ticketService;

    public BuyTicketCommand(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        LOG.debug("Exhibition Id: "+ request.getParameter("exhibitionId"));
        ticketService.buyTicket(
                Integer.parseInt(request.getParameter("exhibitionId")),
                ((User) request.getSession().getAttribute("user")).getId());

        return "redirect: home";
    }
}
