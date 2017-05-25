package semexter.task.mirhusainov.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import semexter.task.mirhusainov.model.Rent;
import semexter.task.mirhusainov.repository.RentJPA;
import semexter.task.mirhusainov.service.RentService;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Ruslan on 22.05.2017.
 */
@Service
public class RentServiceImpl implements RentService {

    @Autowired
    private RentJPA rentJPA;

    @Override
    public void save(Rent rent) {
        rentJPA.save(rent);
    }

    @Override
    public void delete(Rent rent) {
        rentJPA.delete(rent);
    }

    @Override
    public List<Rent> getAll() {
        return rentJPA.findAll();
    }


    @PostConstruct
    private void setTestData(){
        rentJPA.save(new Rent("Ruslan Mirhusainov","89600432896","Aston Martin","2017-05-05","2017-05-28"));
    }
}
