package controller.command;

import service.ExhibitionService;
import service.ExhibitionSeviceImpl;

import javax.servlet.http.HttpServletRequest;

public class HomeCommand implements Command {
    ExhibitionService exhibitionService = new ExhibitionSeviceImpl();

    @Override
    public String execute(HttpServletRequest request) {
        request.getRemoteUser();
        request.getUserPrincipal();
        request.setAttribute("exhibitions", exhibitionService.getAll());
        return "/WEB-INF/home.jsp";
    }
}
