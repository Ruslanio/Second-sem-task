package semexter.task.mirhusainov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import semexter.task.mirhusainov.model.User;

/**
 * Created by Ruslan on 22.05.2017.
 */
@Repository
public interface UserJPA extends JpaRepository<User,Long> {

    User findByLogin(String login);
}
