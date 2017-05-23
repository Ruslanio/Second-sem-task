package semexter.task.mirhusainov.controller;

import com.sun.org.apache.regexp.internal.RE;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import semexter.task.mirhusainov.model.Car;
import semexter.task.mirhusainov.model.Rent;
import semexter.task.mirhusainov.service.RentService;
import semexter.task.mirhusainov.util.Validator;

import javax.annotation.PostConstruct;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by Ruslan on 23.05.2017.
 */
public class FormRentController {

    @Autowired
    private Validator validator;

    @Autowired
    private RentService rentService;
    @FXML
    private TextField et_full_name;
    @FXML
    private TextField et_number;
    @FXML
    private TextField et_model;
    @FXML
    private DatePicker et_delivery_date;
    @FXML
    private DatePicker et_return_date;
    private boolean isUpdating = false;
    private Rent selectedRent;


    public void setSelectedRent(Rent rent){
        isUpdating = true;
        selectedRent = rent;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        et_model.setText(rent.getCarMark());
        et_full_name.setText(rent.getUserFullName());
        et_number.setText(rent.getUserNumber());
        try {
            et_delivery_date.setValue(LocalDate.parse(rent.getDeliveryDate(), dateTimeFormatter));
            et_return_date.setValue(LocalDate.parse(rent.getReturnDate(), dateTimeFormatter));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void clear(){
        selectedRent = null;
        setSelectedRent(new Rent("","","","",""));
        isUpdating = false;

    }
    @Setter
    private ObservableList<Rent> rentsFromTable;

    public void setModel(String model) {
        if (model != null) {
            et_model.setText(model);
        }
    }

    @FXML
    public void submit(ActionEvent event) {
        String fullname = et_full_name.getText();
        String number = et_number.getText();
        String model = et_model.getText();
        String deliveryDate = String.valueOf(et_delivery_date.getValue());
        String returnDate = String.valueOf(et_return_date.getValue());


        validator.isRentFormValid(fullname, number, model, deliveryDate, returnDate);

        Rent newRent = new Rent(fullname, number, model, deliveryDate, returnDate);
        if (selectedRent != null)
            newRent.setId(selectedRent.getId());

        Alert alert;
        try {
            rentService.save(newRent);
            rentsFromTable.add(newRent);
            alert = new Alert(Alert.AlertType.INFORMATION, "rent successfully added");

            if (isUpdating) {
                Rent remember =null;
                for (Rent rent : rentsFromTable) {
                    if (newRent.getId() == rent.getId()) {
                        remember = rent;
                        rentService.delete(rent);
                    }
                }
                rentsFromTable.remove(remember);
            }
        } catch (NullPointerException e){
            rentService.save(newRent);
            alert = new Alert(Alert.AlertType.INFORMATION, "rent successfully added");
        }
        alert.show();

    }
}
