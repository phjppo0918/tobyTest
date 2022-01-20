package springbook.abstractService.service;

import springbook.abstractService.model.User;

import java.util.List;

public interface UserDao {
    public void add(User user);
    public User get(String id);
    public void deleteAll();
    public List<User> getAll();
    public void update(User user);
}
