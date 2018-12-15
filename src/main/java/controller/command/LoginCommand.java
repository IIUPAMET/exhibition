package controller.command;

import model.entity.User;
import service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LoginCommand implements Command {

    private UserService userService = new UserServiceImpl();

    @Override
    public String execute(HttpServletRequest request) {

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
        Map<String, HttpSession> loggedUsers = getLoggedUsers(request);
        String login = user.getLogin();

        if (loggedUsers.containsKey(login)) {
            loggedUsers.get(login).invalidate();
        }

        loggedUsers.put(login, request.getSession());
        setLoggedUsers(request, loggedUsers);

        sessionSetup(request, user);
    }

    private void sessionSetup(HttpServletRequest request, User user) {
        request.getSession().setAttribute("user", user);
    }

    private Map<String, HttpSession> getLoggedUsers(HttpServletRequest request) {
        return (Map<String, HttpSession>) request.getServletContext().getAttribute("loggedUsers");
    }

    private void setLoggedUsers(HttpServletRequest request, Map<String, HttpSession> loggedUsers) {
        request.getServletContext().setAttribute("loggedUsers", loggedUsers);
    }
}
