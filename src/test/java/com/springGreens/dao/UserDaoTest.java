package com.springGreens.dao;

import com.springGreens.config.Config;
import com.springGreens.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class UserDaoTest {
    @Autowired
    private ApplicationContext context;

    private UserDao userDao;
    private User user1,user2,user3;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Before
    public void setUp() {
        //userDao = context.getBean("userDao", UserDao.class);
        user1 = new User("지미", "1234", "1234");
        user2 = new User("승진", "435", "2435");
        user3 = new User("수빈", "1223454", "2435");
    }

    @Test
    public void addAndGet() throws ClassNotFoundException, SQLException {
        userDao.deleteAll();
        userDao.add(user1);

        User user2 = userDao.get(user1.getId());

        assertThat(user1.getId(), is(user2.getId()));
        assertThat(user1.getName(), is(user2.getName()));
        assertThat(user1.getPassword(), is(user2.getPassword()));

    }

    @Test
    public void getCount() throws ClassNotFoundException, SQLException {

        userDao.deleteAll();
        assertThat(userDao.getCount(), is(0));

        userDao.add(user1);
        assertThat(userDao.getCount(), is(1));

        userDao.add(user2);
        assertThat(userDao.getCount(), is(2));

        userDao.add(user3);
        assertThat(userDao.getCount(), is(3));
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void userNotFound() throws ClassNotFoundException, SQLException {
        userDao.deleteAll();
        assertThat(userDao.getCount(), is(0));
        userDao.get("uuuuuu");
    }
}
