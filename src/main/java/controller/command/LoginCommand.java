package controller.command;

import controller.ServletUtil;
import model.entity.User;
import service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Optional;

public class LoginCommand implements Command {

    private UserService userService = new UserServiceImpl();

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
        Map<String, HttpSession> loggedUsers = ServletUtil.getLoggedUsers(request);
        String login = user.getLogin();

        if (loggedUsers.containsKey(login)) {
            loggedUsers.get(login).invalidate();
        }

        loggedUsers.put(login, request.getSession());
        ServletUtil.setLoggedUsers(request, loggedUsers);

        sessionSetup(request, user);
    }

    private void sessionSetup(HttpServletRequest request, User user) {
        request.getSession().setAttribute("user", user);
    }
}
