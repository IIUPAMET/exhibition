package controller.command;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CreateExhibitionPageCommand implements Command {
    public static final Logger LOG = Logger.getLogger(CreateExhibitionPageCommand.class);
    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/admin/create_exhibition.jsp";
    }
}
