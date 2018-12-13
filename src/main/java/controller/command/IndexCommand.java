package controller.command;

import model.dao.ExhibitionDao;
import model.dao.impl.DaoFactory;
import model.entity.Exhibition;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class IndexCommand implements Command {

    DaoFactory daoFactory = DaoFactory.getInstance();
    ExhibitionDao exhibitionDao = daoFactory.createExhibitionDao();
    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute("exhibition",exhibitionDao.findAll());
        return "/index.jsp";
    }
}
