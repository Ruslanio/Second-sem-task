package semexter.task.mirhusainov.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Ruslan on 22.05.2017.
 */
@Entity
@Table(name = "rent")
@Getter
@Setter
public class Rent {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "userFullName")
    private String userFullName;

    @Column(name = "userNumber")
    private String userNumber;

    @Column(name = "carMark")
    private String carMark;

    @Column(name = "deliveryDate")
    private String deliveryDate;

    @Column(name = "returnDate")
    private String returnDate;

    public Rent() {
    }

    public Rent(String userFullName, String userNumber, String carMark, String deliveryDate, String returnDate) {
        this.userFullName = userFullName;
        this.userNumber = userNumber;
        this.carMark = carMark;
        this.deliveryDate = deliveryDate;
        this.returnDate = returnDate;
    }
}
