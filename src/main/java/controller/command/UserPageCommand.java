package controller.command;

import model.entity.User;
import org.apache.log4j.Logger;
import service.ExhibitionService;
import service.ExhibitionSeviceImpl;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;
import java.text.ParseException;

public class UserPageCommand implements Command {
    public static final Logger LOG = Logger.getLogger(UserPageCommand.class);
    private ExhibitionService exhibitionService;

    public UserPageCommand(ExhibitionService exhibitionService) {
        this.exhibitionService = exhibitionService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        LOG.debug(MessageFormat.format("User page for userId ''{0}''", ((User)request.getSession().getAttribute("user")).getId()));
        Integer userId = ((User)request.getSession().getAttribute("user")).getId();
        request.setAttribute("exhibitions", exhibitionService.getExhibitionForUser(userId));

        return "/WEB-INF/user/user.jsp";
    }
}
