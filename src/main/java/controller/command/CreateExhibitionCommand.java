package controller.command;

import service.ExhibitionService;
import service.ExhibitionSeviceImpl;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CreateExhibitionCommand implements Command{

    private ExhibitionService exhibitionService = new ExhibitionSeviceImpl();

    @Override
    public String execute(HttpServletRequest request) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        Map<String, String> fieldsMap = new ConcurrentHashMap<>();
        fieldsMap.put("exhibition_name", request.getParameter("exhibition_name"));
        fieldsMap.put("start_date", request.getParameter("start_date"));
        fieldsMap.put("end_date", request.getParameter("end_date"));
        fieldsMap.put("theme", request.getParameter("theme"));
        fieldsMap.put("author", request.getParameter("author"));
        // TO DO
            exhibitionService.crateExhibition(request.getParameter("exhibition_name"),
                    LocalDate.parse(request.getParameter("start_date"),formatter),
                    LocalDate.parse(request.getParameter("end_date"),formatter),
                    request.getParameter("theme"),
                    request.getParameter("author")
                    );

        return "redirect: home";
    }
}
