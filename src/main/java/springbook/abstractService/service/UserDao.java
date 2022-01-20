package springbook.abstractService.service;

import springbook.abstractService.model.User;

public interface UserDao {
    public void add(User user);
    public User get(String id);
    public void deleteAll();
    public void update(User user);
}
