package controller.command;

import model.entity.User;
import org.apache.log4j.Logger;
import service.UserService;

import javax.servlet.http.HttpServletRequest;

public class AddWishCommand implements Command {
    public static final Logger LOG = Logger.getLogger(AddWishCommand.class);

    private UserService userService;

    public AddWishCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        LOG.debug("Exhibition Id: "+ request.getParameter("addWish"));
        User user = (User) request.getSession().getAttribute("user");
        Integer id = Integer.parseInt(request.getParameter("addWish"));
        userService.addWish(user.getId(), id);

        return ("redirect: home");
    }
}
