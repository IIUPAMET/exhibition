package controller.command;

import javax.servlet.http.HttpServletRequest;

public class IndexPageCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        return "/index.jsp";
    }
}
