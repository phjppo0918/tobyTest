package springbook.abstractService.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springbook.abstractService.configuration.Config;
import springbook.abstractService.model.Level;
import springbook.abstractService.model.User;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class UserServiceTest {
    @Autowired
    UserService userService;
    @Autowired
    UserDao userDao;
    List<User> users;
    @Before
    public void setUp() {
        users = Arrays.asList(
                new User("aaa", "aaaa", "11", Level.BASIC, 49, 0),
                new User("bbb", "bbbb", "11", Level.BASIC, 50, 0),
                new User("ccc", "cccc", "11", Level.SILVER, 60, 29),
                new User("ddd", "dddd", "11", Level.SILVER, 62, 30),
                new User("eee", "eeee", "11", Level.BASIC, 60, 40),
                new User("fff", "ffff", "11", Level.GOLD, 100, 100)
        );
    }

    @Test
    public void upgradeLevels() {
        userDao.deleteAll();

        for(User user : users) userDao.add(user);

        userService.upgradeLevels();

        checkLevel(users.get(0), Level.BASIC);
        checkLevel(users.get(1), Level.SILVER);
        checkLevel(users.get(2), Level.SILVER);
        checkLevel(users.get(3), Level.GOLD);
        checkLevel(users.get(4), Level.SILVER);
        checkLevel(users.get(5), Level.GOLD);
    }

    private void checkLevel(User user, Level expectedLevel) {
        User userUpdate = userDao.get(user.getId());
        assertThat(userUpdate.getLevel(), is(expectedLevel));
    }
}