package controller.command;

import javax.servlet.http.HttpServletRequest;

public class HomeCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "WEB-INF/home";
    }
}
