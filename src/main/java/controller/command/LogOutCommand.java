package controller.command;

import controller.ServletUtil;
import model.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.Map;

public class LogOutCommand implements Command {
    public static final Logger LOG = Logger.getLogger(LogOutCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        Map<String,HttpSession> loggedUsers = ServletUtil.getLoggedUsers(request);
        LOG.debug("User prepare before Log Out: "+ request.getSession().getAttribute("user").toString());
        loggedUsers.remove( ((User)request.getSession().getAttribute("user")).getLogin());
        ServletUtil.setLoggedUsers(request, loggedUsers);
        LOG.debug("User successful Log Out"+ request.getSession().getAttribute("user").toString());
        request.getSession().removeAttribute("user");
        return "redirect: index";
    }
}
