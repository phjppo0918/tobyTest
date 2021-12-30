package springbook.user.dao;

import springbook.util.ConnectionMaker;
import springbook.util.impl.DConnectionMaker;

public class DaoFactory {
    public UserDao userDao() {
        ConnectionMaker connectionMaker = new DConnectionMaker();
        UserDao userDao = new UserDao(connectionMaker);

        return userDao;
    }
}
