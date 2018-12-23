package controller.command;

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
        request.setAttribute("exhibitions", exhibitionService.getAll());
        return "/WEB-INF/user/user.jsp";
    }
}
