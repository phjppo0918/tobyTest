package springbook.abstractService.service.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import springbook.abstractService.model.Level;
import springbook.abstractService.model.User;
import springbook.abstractService.service.UserDao;

import javax.sql.DataSource;
import java.util.List;

public class UserDaoJDBC implements UserDao {
    private JdbcTemplate jdbcTemplate;
    private RowMapper<User> userRowMapper =
            (rs, rowNum) -> new User(
                    rs.getString("id"),
                    rs.getString("name"),
                    rs.getString("password"),
                    Level.valueOf(rs.getInt("level")),
                    rs.getInt("login"),
                    rs.getInt("recommend")
            );

    public UserDaoJDBC(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void add(User user) {
        this.jdbcTemplate.update("insert into user(id, name, password, level, login, recommend) values (?,?,?,?,?,?)",
                user.getId(), user.getName(), user.getPassword(), user.getLevel().intValue(), user.getLogin(), user.getRecommend());
    }



    @Override
    public User get(String id) {
        return this.jdbcTemplate.queryForObject("select * from user where id = ?",
                new Object[]{id}, this.userRowMapper);
    }

    @Override
    public void deleteAll() {
        this.jdbcTemplate.update("delete from user ");
    }

    @Override
    public void update(User user) {
        this.jdbcTemplate.update(
                "update user set name = ?, password = ?, level = ?," +
                        " login = ?, recommend = ? where id = ?",
                user.getName(), user.getPassword(), user.getLevel().intValue(),
                user.getLogin(), user.getRecommend(), user.getId());
    }

    @Override
    public List<User> getAll() {
        return this.jdbcTemplate.query("select * from user order by id", this.userRowMapper);
    }
}
