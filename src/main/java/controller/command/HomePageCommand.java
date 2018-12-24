package controller.command;

import model.entity.User;
import service.ExhibitionService;
import service.ExhibitionSeviceImpl;
import service.RequestService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class HomePageCommand implements Command {
    ExhibitionService exhibitionService;
    RequestService requestService;

    public HomePageCommand(ExhibitionService exhibitionService, RequestService requestService){
        this.exhibitionService = exhibitionService;
        this.requestService = requestService;
    }
    @Override
    public String execute(HttpServletRequest request) {

        Integer userId = Integer.valueOf(0);
        if(request.getSession().getAttribute("user") != null){

            userId = ((User)request.getSession().getAttribute("user")).getId();
        }
        request.setAttribute("wishlist", requestService.getWithListByUserId(userId));
        request.setAttribute("exhibitions", exhibitionService.getAll());
        return "/WEB-INF/home.jsp";
    }
}
