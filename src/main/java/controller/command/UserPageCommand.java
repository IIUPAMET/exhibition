package controller.command;

import service.ExhibitionService;
import service.ExhibitionSeviceImpl;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public class UserPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws ParseException {
        ExhibitionService exhibitionService = new ExhibitionSeviceImpl();
        request.setAttribute("exhibitions", exhibitionService.getAll());
        return "/WEB-INF/user/user.jsp";
    }
}
