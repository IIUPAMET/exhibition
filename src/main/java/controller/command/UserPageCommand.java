package controller.command;

import model.entity.User;
import service.ExhibitionService;
import service.ExhibitionSeviceImpl;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public class UserPageCommand implements Command {
    ExhibitionService exhibitionService;

    public UserPageCommand(ExhibitionService exhibitionService) {
        this.exhibitionService = exhibitionService;
    }

    @Override
    public String execute(HttpServletRequest request) throws ParseException {
        Integer userId = ((User)request.getSession().getAttribute("user")).getId();
        request.setAttribute("exhibitions", exhibitionService.getExhibitionForUser(userId));
        return "/WEB-INF/user/user.jsp";
    }
}
