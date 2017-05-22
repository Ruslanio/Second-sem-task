package semexter.task.mirhusainov.service;

import semexter.task.mirhusainov.model.Rent;

import java.util.List;

/**
 * Created by Ruslan on 22.05.2017.
 */
public interface RentService {

    public void safe(Rent rent);
    public void delete(Rent rent);
    public List<Rent> getAll();
}
