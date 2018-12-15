package service;

import model.dao.ExhibitionDao;
import model.dao.impl.DaoFactory;
import model.dao.impl.JDBCDaoFactory;
import model.entity.Exhibition;

import java.util.List;

public class ExhibitionSeviceImpl implements ExhibitionService {

    private DaoFactory daoFactory = JDBCDaoFactory.getInstance();

    @Override
    public List<Exhibition> getAll() {
        try (ExhibitionDao dao = daoFactory.createExhibitionDao()) {
        return dao.findAll();
    }
    }
}
