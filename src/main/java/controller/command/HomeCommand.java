package controller.command;

import model.dao.UserDao;
import model.dao.impl.DaoFactory;
import model.dao.impl.JDBCUserDao;
import model.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class HomeCommand implements Command {

    private DaoFactory daoFactory = DaoFactory.getInstance();
    private UserDao jdbcUserDao = daoFactory.createUserDao();

    @Override
    public String execute(HttpServletRequest request) {
        if(request.getParameter("command")!= null && request.getParameter("command").equals("Add")) {
            User create = new User();
            create.setId(Integer.parseInt(request.getParameter("id")));
            create.setLogin(request.getParameter("login"));
            create.setPass(request.getParameter("pass"));
            jdbcUserDao.create(create);
        }
        request.setAttribute("user", jdbcUserDao.findById(1));
        return "/WEB-INF/home.jsp";
    }
}
