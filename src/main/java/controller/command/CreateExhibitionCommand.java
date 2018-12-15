package controller.command;

import javax.servlet.http.HttpServletRequest;

public class CreateExhibitionCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/admin/create_exhibition.jsp";
    }
}
