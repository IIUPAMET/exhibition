package model.dao.impl;

import model.dao.ExhibitionDao;
import model.dao.UserDao;

public abstract class DaoFactory {
    private static DaoFactory daoFactory;

    public abstract UserDao createUserDao();
    public abstract ExhibitionDao createExhibitionDao();

    public static DaoFactory getInstance(){
        if( daoFactory == null ){
            synchronized (DaoFactory.class){
                if(daoFactory==null){
                    daoFactory =  new JDBCDaoFactory();
                }
            }
        }
        return daoFactory;
    }
}
