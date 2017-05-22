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
public class Car {

    @Id
    @GeneratedValue
    private Long id;

    private String mark;

    private int year;

    private int mileage;

    private int enginePower;

    private int costPerHour;

    public Car() {
    }

    public Car(String mark, int year, int mileage, int enginePower, int costPerHour) {
        this.mark = mark;
        this.year = year;
        this.mileage = mileage;
        this.enginePower = enginePower;
        this.costPerHour = costPerHour;
    }
}
