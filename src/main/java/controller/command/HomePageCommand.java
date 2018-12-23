package controller.command;

import service.ExhibitionService;
import service.ExhibitionSeviceImpl;

import javax.servlet.http.HttpServletRequest;

public class HomePageCommand implements Command {
    ExhibitionService exhibitionService;

    public HomePageCommand(ExhibitionService exhibitionService){
        this.exhibitionService = exhibitionService;
    }
    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute("exhibitions", exhibitionService.getAll());
        return "/WEB-INF/home.jsp";
    }
}
