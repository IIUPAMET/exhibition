package controller.command;

import controller.ServletUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.Map;

public class LogOutCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) throws ParseException {
        Map<String,HttpSession> loggedUsers = ServletUtil.getLoggedUsers(request);
        loggedUsers.remove( request.getSession().getAttribute("user"));
        ServletUtil.setLoggedUsers(request, loggedUsers);
        request.getSession().removeAttribute("user");
        return "redirect: index";
    }
}
