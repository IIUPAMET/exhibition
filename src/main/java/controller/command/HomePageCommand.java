package controller.command;

import model.dao.impl.JDBCExhibitionDao;
import model.entity.User;
import org.apache.log4j.Logger;
import service.ExhibitionService;
import service.ExhibitionSeviceImpl;
import service.RequestService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class HomePageCommand implements Command {
    public static final Logger LOG = Logger.getLogger(HomePageCommand.class);
    private ExhibitionService exhibitionService;
    private RequestService requestService;

    public HomePageCommand(ExhibitionService exhibitionService, RequestService requestService) {
        this.exhibitionService = exhibitionService;
        this.requestService = requestService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        Integer userId = null;
        if (request.getSession().getAttribute("user") != null) {
            userId = ((User) request.getSession().getAttribute("user")).getId();
        }
        int page;
        int recordsPerPage = 5;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }else {
            page = 1;
        }
        request.setAttribute("exhibitions", exhibitionService.viewAllExhibition((page - 1) * recordsPerPage, recordsPerPage));
        request.setAttribute("wishlist", requestService.getWithListByUserId(userId));
        int noOfRecords = JDBCExhibitionDao.getNoOfRecords();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        return "/WEB-INF/home.jsp";
    }
}
