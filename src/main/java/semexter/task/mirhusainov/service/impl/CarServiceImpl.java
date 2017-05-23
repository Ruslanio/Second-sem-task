package semexter.task.mirhusainov.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import semexter.task.mirhusainov.model.Car;
import semexter.task.mirhusainov.repository.CarJPA;
import semexter.task.mirhusainov.service.CarService;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Ruslan on 22.05.2017.
 */
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarJPA carJPA;

    @Override
    public List<Car> getAll() {
        return carJPA.findAll();
    }

    @Override
    public Car getByMark(String mark) {
        return carJPA.findByMark(mark);
    }

    @Override
    public void save(Car car) {
        carJPA.save(car);
    }

    @Override
    public void delete(Car car) {
        carJPA.delete(car);
    }

    @PostConstruct
    private void setTestData(){
        carJPA.save(new Car("lambo","1993","45000","250","10000"));
        carJPA.save(new Car("Jigoolee","1967","300000","60","500"));
    }
}
