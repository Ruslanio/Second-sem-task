package semexter.task.mirhusainov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import semexter.task.mirhusainov.model.Rent;

/**
 * Created by Ruslan on 22.05.2017.
 */
public interface RentJPA extends JpaRepository<Rent,Long> {
}
