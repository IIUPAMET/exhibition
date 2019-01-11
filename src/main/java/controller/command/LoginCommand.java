package controller.command;

import controller.ServletUtil;
import model.entity.User;
import org.apache.log4j.Logger;
import service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.MessageFormat;
import java.util.Map;
import java.util.Optional;

public class LoginCommand implements Command {
    public static final Logger LOG = Logger.getLogger(LoginCommand.class);

    private UserService userService;

    public LoginCommand(UserService userService){
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        if(request.getSession().getAttribute("user") != null){
            return "redirect: logout";
        }

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (login.equals("") || password.equals("") || login == null || password == null) {
            return "/index.jsp";
        }
        Optional<User> user = userService.login(login, password);
        if (user.isPresent()) {
            logIn(request, user.get());
            return "redirect: home";
        } else {
            return "/index.jsp";
        }
    }

    private void logIn(HttpServletRequest request, User user) {
        LOG.debug(MessageFormat.format("User ''{0}'' tries to log in", user.getLogin()));

        Map<String, HttpSession> loggedUsers = ServletUtil.getLoggedUsers(request);
        String login = user.getLogin();

        if (loggedUsers.containsKey(login)) {
            LOG.debug(MessageFormat.format("User ''{0}'' stare of invalidate session", user.getLogin()));
            loggedUsers.get(login).invalidate();
        }

        loggedUsers.put(login, request.getSession());
        ServletUtil.setLoggedUsers(request, loggedUsers);

        sessionSetup(request, user);

        LOG.debug(MessageFormat.format("User ''{0}'' successfully logged in", user.getLogin()));
    }

    private void sessionSetup(HttpServletRequest request, User user) {
        request.getSession().setAttribute("user", user);
    }
}
