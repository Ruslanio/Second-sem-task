package semexter.task.mirhusainov.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import semexter.task.mirhusainov.model.Car;
import semexter.task.mirhusainov.service.CarService;
import semexter.task.mirhusainov.util.Validator;

/**
 * Created by Ruslan on 23.05.2017.
 */
public class FormCarController {

    @Autowired
    private Validator validator;

    @FXML
    private TextField et_mark;

    @FXML
    private TextField et_year;

    @FXML
    private TextField et_mileage;

    @FXML
    private TextField et_engine_power;

    @FXML
    private TextField et_cost;

    @Autowired
    private CarService carService;

    @Setter
    private ObservableList<Car> carsFromTable;

    private boolean isUpdating = false;
    private Car selectedCar;

    @FXML
    public void submit(ActionEvent event) {
        String mark = et_mark.getText();
        String year = et_year.getText();
        String mileage = et_mileage.getText();
        String enginePower = et_engine_power.getText();
        String costPerHour = et_cost.getText();

        validator.isCarFormValid(mark, year, mileage, enginePower, costPerHour);

        Car newCar = new Car(mark, year, mileage, enginePower, costPerHour);
        if (selectedCar != null)
            newCar.setId(selectedCar.getId());


        carService.save(newCar);
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "car successfully added");
        carsFromTable.add(newCar);

        if (isUpdating) {
            Car remember = null;
            for (Car car : carsFromTable) {
                if (newCar.getId() == car.getId()) {
                    remember = car;
                    carService.delete(car);
                }
            }
            carsFromTable.remove(remember);

        }

        alert.show();

    }

    public void setSelectedCar(Car car) {
        selectedCar = car;
        isUpdating = true;
        et_mark.setText(car.getMark());
        et_year.setText(car.getYear());
        et_mileage.setText(car.getMileage());
        et_engine_power.setText(car.getEnginePower());
        et_cost.setText(car.getCostPerHour());
    }

    public void clear() {
        selectedCar = null;
        setSelectedCar(new Car("", "", "", "", ""));
        isUpdating = false;
    }
}
