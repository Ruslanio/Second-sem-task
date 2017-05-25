package semexter.task.mirhusainov.controller.util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import semexter.task.mirhusainov.config.MainConfig;
import semexter.task.mirhusainov.model.Car;
import semexter.task.mirhusainov.model.Rent;
import semexter.task.mirhusainov.service.CarService;
import semexter.task.mirhusainov.service.RentService;


import java.util.List;

/**
 * Created by Ruslan on 23.05.2017.
 */
@Component
public class SceneChangesHandler {

//    @Autowired
//    CarService carService;

    private static SceneChangesHandler sceneChangesHandler;
    private ObservableList<Car> forTableCars;
    private ObservableList<Rent> forTableRents;

    private SceneChangesHandler() {
    }

    public static SceneChangesHandler getInstance(){
        if (sceneChangesHandler == null){
            sceneChangesHandler = new SceneChangesHandler();
        }
        return sceneChangesHandler;
    }

    public void nextScene(ActionEvent event, MainConfig.View view){
        Parent parent = view.getView();

        Scene scene = parent.getScene();
        if (scene == null){
            scene = new Scene(parent);
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();
    }

    public Stage newStage(MainConfig.View view){
        Parent parent = view.getView();
        Scene scene  = parent.getScene();

        if (scene == null){
            scene = new Scene(parent);
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        return stage;
    }

    //carService по непонятным причинам не автоварится, хотя идейка все зависимости показывает
    public ObservableList initCarTable(TableView tableView,CarService carService){
        List<Car> cars = carService.getAll();
        forTableCars = FXCollections.observableArrayList(cars);

        TableColumn<Car, String> model = new TableColumn<>("Mark/Model");
        model.setCellValueFactory(new PropertyValueFactory<>("mark"));

        TableColumn<Car, String> year = new TableColumn<>("Year");
        year.setCellValueFactory(new PropertyValueFactory<>("year"));

        TableColumn<Car, String> mileage = new TableColumn<>("Mileage");
        mileage.setCellValueFactory(new PropertyValueFactory<>("mileage"));

        TableColumn<Car, String> enginePower = new TableColumn<>("Engine Rower (h. p.)");
        enginePower.setCellValueFactory(new PropertyValueFactory<>("enginePower"));

        TableColumn<Car, String> costPerHour = new TableColumn<>("Cost per hour");
        costPerHour.setCellValueFactory(new PropertyValueFactory<>("costPerHour"));

        tableView.getColumns().setAll(model, year, mileage, enginePower, costPerHour);
        tableView.setItems(forTableCars);

        return forTableCars;
    }
    public ObservableList initRentTable(TableView tableView,RentService rentService){
        List<Rent> rents = rentService.getAll();
        forTableRents = FXCollections.observableArrayList(rents);

        TableColumn<Car, String> fullName = new TableColumn<>("Full name");
        fullName.setCellValueFactory(new PropertyValueFactory<>("userFullName"));

        TableColumn<Car, String> number = new TableColumn<>("Number");
        number.setCellValueFactory(new PropertyValueFactory<>("userNumber"));

        TableColumn<Car, String> model = new TableColumn<>("Mark/Model");
        model.setCellValueFactory(new PropertyValueFactory<>("carMark"));

        TableColumn<Car, String> deliveryDate = new TableColumn<>("Delivery Date");
        deliveryDate.setCellValueFactory(new PropertyValueFactory<>("deliveryDate"));

        TableColumn<Car, String> returnDate = new TableColumn<>("Return date");
        returnDate.setCellValueFactory(new PropertyValueFactory<>("returnDate"));

        tableView.getColumns().setAll(fullName,number,model,deliveryDate,returnDate);
        tableView.setItems(forTableRents);

        return forTableRents;
    }

    public void addCarToTables(Car car){
        forTableCars.add(car);
    }
    public void addRentToTables(Rent rent){
        forTableRents.add(rent);
    }
}
