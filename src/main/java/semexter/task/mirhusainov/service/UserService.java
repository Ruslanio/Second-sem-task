package semexter.task.mirhusainov.service;

import semexter.task.mirhusainov.model.User;

import java.util.List;

/**
 * Created by Ruslan on 22.05.2017.
 */
public interface UserService {

    public void save(User user);
    public void delete(User user);
    public User getByLogin(String login);
    public List<User> getAll();
}
