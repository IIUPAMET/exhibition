package service;

import model.dao.RequestDao;

import java.util.Map;

public class RequestService {
    RequestDao requestDao;

    public RequestService(RequestDao requestDao) {
        this.requestDao = requestDao;
    }
    public Map<Integer, Integer> getWithListByUserId(int userId){
        return requestDao.getWithListByUserId(userId);
    }
}
