package model.dao;

import model.entity.Request;

import java.util.Map;
import java.util.Set;

public interface RequestDao extends GenericDao<Request> {
    Map<Integer, Integer> getWithListByUserId(int userId);
}
