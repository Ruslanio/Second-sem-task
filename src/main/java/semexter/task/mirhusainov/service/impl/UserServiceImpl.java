package semexter.task.mirhusainov.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import semexter.task.mirhusainov.model.User;
import semexter.task.mirhusainov.repository.UserJPA;
import semexter.task.mirhusainov.service.UserService;

import java.util.List;

/**
 * Created by Ruslan on 22.05.2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserJPA userJPA;

    @Override
    public void save(User user) {
        userJPA.save(user);
    }

    @Override
    public void delete(User user) {
        userJPA.delete(user);
    }

    @Override
    public User getByLogin(String login) {
        return userJPA.findByLogin(login);
    }

    @Override
    public List<User> getAll() {
        return userJPA.findAll();
    }
}
