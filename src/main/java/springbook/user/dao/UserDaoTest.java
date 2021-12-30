package springbook.user.dao;

import springbook.user.domain.User;
import springbook.util.ConnectionMaker;
import springbook.util.impl.DConnectionMaker;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ConnectionMaker connectionMaker = new DConnectionMaker();

        UserDao dao = new UserDao(connectionMaker);

        User user = new User();
        user.setId("whiteship");
        user.setName("test");
        user.setPassword("1234");

        dao.add(user);

        System.out.println(user.getId() + "등록성공");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());

        System.out.println(user2.getId() + "조회성공");
    }
}
