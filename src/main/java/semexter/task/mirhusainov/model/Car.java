package semexter.task.mirhusainov.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Ruslan on 22.05.2017.
 */
@Entity
@Table(name = "car")
@Getter
@Setter
public class Car {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "mark")
    private String mark;

    @Column(name = "year")
    private String year;

    @Column(name = "mileage")
    private String mileage;

    @Column(name = "enginePower")
    private String enginePower;

    @Column(name = "costPerHour")
    private String costPerHour;

    public Car() {
    }

    public Car(String mark, String year, String mileage, String enginePower, String costPerHour) {
        this.mark = mark;
        this.year = year;
        this.mileage = mileage;
        this.enginePower = enginePower;
        this.costPerHour = costPerHour;
    }
}
