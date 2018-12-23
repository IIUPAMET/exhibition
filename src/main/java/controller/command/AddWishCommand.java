package controller.command;

import model.entity.User;
import service.UserService;
import service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public class AddWishCommand implements Command {
    private UserService userService;

    public AddWishCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) throws ParseException {

        User user = (User) request.getSession().getAttribute("user");
        Integer id = Integer.parseInt(request.getParameter("addwish"));
        userService.addwish(user.getId(), id);

        return ("redirect: home");
    }
}
