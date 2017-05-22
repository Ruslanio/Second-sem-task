package semexter.task.mirhusainov.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Ruslan on 22.05.2017.
 */
@Entity
@Table
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String login;


    private String password;

    public User() {

    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
