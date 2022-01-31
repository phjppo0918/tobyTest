package springbook.abstractService.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.springbook.abstractService.configuration.Config;
import com.springbook.abstractService.model.Level;
import com.springbook.abstractService.model.User;
import com.springbook.abstractService.service.UserDao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserDaoJDBCTest {
    @Autowired
    private ApplicationContext context;

    @Autowired
    private UserDao dao;

    private User user1, user2, user3;
    @Before
    public void setUp() {
        context = new AnnotationConfigApplicationContext(Config.class);
        dao = context.getBean("userDao", UserDao.class);
        this.user1 = new User("aaa","홍","1234", Level.BASIC, 1, 0);
        this.user2 = new User("bbb","이","4567", Level.SILVER, 55, 10);
        this.user3 = new User("ccc","김","6789", Level.GOLD, 100, 40);
    }

    @Test
    public void addAndGet() {
        dao.deleteAll();

        dao.add(user1);
        User userGet1 = dao.get(user1.getId());
        checkSameUser(userGet1, user1);

        dao.add(user2);
        User userGet2 = dao.get(user2.getId());
        checkSameUser(userGet2, user2);

        dao.add(user3);
        User userGet3 = dao.get(user3.getId());
        checkSameUser(userGet3, user3);
    }

    @Test
    public void update() {
        dao.deleteAll();

        dao.add(user1);

        user1.setName("가나다");
        user1.setPassword("12341234");
        user1.setLevel(Level.GOLD);
        user1.setLogin(1000);
        user1.setRecommend(999);

        dao.update(user1);

        User user1Update = dao.get(user1.getId());
        checkSameUser(user1, user1Update);
    }

    private void checkSameUser(User user1, User user1Update) {
        assertThat(user1.getId(), is(user1Update.getId()));
        assertThat(user1.getPassword(), is(user1Update.getPassword()));
        assertThat(user1.getName(), is(user1Update.getName()));
        assertThat(user1.getLogin(), is(user1Update.getLogin()));
        assertThat(user1.getLevel(), is(user1Update.getLevel()));
        assertThat(user1.getRecommend(), is(user1Update.getRecommend()));
    }

}