package semexter.task.mirhusainov.service;

import semexter.task.mirhusainov.model.Car;

import java.util.List;

/**
 * Created by Ruslan on 22.05.2017.
 */
public interface CarService {
    public List<Car> getAll();
    public Car getByMark(String mark);
    public void save(Car car);
    public void delete(Car car);
}
