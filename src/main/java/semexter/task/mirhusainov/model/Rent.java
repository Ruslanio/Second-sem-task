package semexter.task.mirhusainov.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Ruslan on 22.05.2017.
 */
@Entity
@Table
@Getter
@Setter
public class Rent {

    @Id
    @GeneratedValue
    private Long id;

    private String userFullName;

    private int userNumber;

    private String carMark;

    private String deliveryDate;

    private String returnDate;

    public Rent() {
    }

    public Rent(String userFullName, int userNumber, String carMark, String deliveryDate, String returnDate) {
        this.userFullName = userFullName;
        this.userNumber = userNumber;
        this.carMark = carMark;
        this.deliveryDate = deliveryDate;
        this.returnDate = returnDate;
    }
}
