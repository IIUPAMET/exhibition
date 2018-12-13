package controller.command;

import model.entity.User;
import service.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class LoginCommand implements Command {

    private UserService userService = new UserServiceImpl();

    @Override
    public String execute(HttpServletRequest request) {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if( login == "" || password == "" || login == null || password == null ){
            return "/index.jsp";
        }
        Optional<User> user = userService.login(login, password);
        if(user.isPresent()){
            request.getSession().setAttribute("user", user.get());
            return "redirect: home";
        }else {
            return "/index.jsp";
        }
    }
}
