package controller.command;

import model.dao.impl.JDBCExhibitionDao;
import model.entity.User;
import service.ExhibitionService;
import service.ExhibitionSeviceImpl;
import service.RequestService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class HomePageCommand implements Command {
    ExhibitionService exhibitionService;
    RequestService requestService;

    public HomePageCommand(ExhibitionService exhibitionService, RequestService requestService) {
        this.exhibitionService = exhibitionService;
        this.requestService = requestService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        Integer userId = Integer.valueOf(0);
        if (request.getSession().getAttribute("user") != null) {

            userId = ((User) request.getSession().getAttribute("user")).getId();
        }
        int page = 1;
        int recordsPerPage = 2;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        request.setAttribute("exhibitions", exhibitionService.viewAllExhibition((page - 1) * recordsPerPage, recordsPerPage));
        int noOfRecords = JDBCExhibitionDao.getNoOfRecords();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        request.setAttribute("wishlist", requestService.getWithListByUserId(userId));
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        return "/WEB-INF/home.jsp";
    }
}
