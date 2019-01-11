package service;

import controller.command.BuyTicketCommand;
import model.dao.RequestDao;
import org.apache.log4j.Logger;

import java.util.Map;

public class RequestService {
    public static final Logger LOG = Logger.getLogger(BuyTicketCommand.class);
    private RequestDao requestDao;

    public RequestService(RequestDao requestDao) {
        this.requestDao = requestDao;
    }

    public Map<Integer, Integer> getWithListByUserId(int userId) {
        return requestDao.getWithListByUserId(userId);
    }
}
