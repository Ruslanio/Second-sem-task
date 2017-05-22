package semexter.task.mirhusainov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import semexter.task.mirhusainov.model.Car;

/**
 * Created by Ruslan on 22.05.2017.
 */
public interface CarJPA extends JpaRepository<Car,Long> {
    Car findByMark(String mark);
}
