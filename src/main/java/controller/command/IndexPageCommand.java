package controller.command;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class IndexPageCommand implements Command {
    public static final Logger LOG = Logger.getLogger(IndexPageCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        return "/index.jsp";
    }
}
