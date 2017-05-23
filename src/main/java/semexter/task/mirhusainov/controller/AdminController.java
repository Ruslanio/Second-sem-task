package semexter.task.mirhusainov.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import semexter.task.mirhusainov.config.MainConfig;
import semexter.task.mirhusainov.controller.util.SceneChangesHandler;

import javafx.event.ActionEvent;
import semexter.task.mirhusainov.model.Car;
import semexter.task.mirhusainov.model.Rent;
import semexter.task.mirhusainov.service.CarService;
import semexter.task.mirhusainov.service.RentService;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Ruslan on 23.05.2017.
 */
public class AdminController {

    private ObservableList<Car> carData;
    private ObservableList<Rent> rentData;

    @Autowired
    MainConfig.View homeView;
    @Autowired
    private CarService carService;

    @Autowired
    private RentService rentService;

    @FXML
    private TableView<Car> carTableView;

    @FXML
    private TableView<Rent> rentTableView;

    @Autowired
    private MainConfig.View formCarView;

    @Autowired
    private MainConfig.View formRentView;

    SceneChangesHandler handler;

    public AdminController() {
        handler = SceneChangesHandler.getInstance();
    }

    @FXML
    public void addCar(ActionEvent event) {
        FormCarController controller = (FormCarController) formCarView.getController();
        controller.setCarsFromTable(carData);
        controller.clear();
        Stage stage = handler.newStage(formCarView);
        stage.showAndWait();
    }

    @FXML
    public void removeCar(ActionEvent event) {
        Car car = carTableView.getSelectionModel().getSelectedItem();
        carService.delete(car);
        carTableView.getItems().remove(car);
    }

    @FXML
    public void updateCar(ActionEvent event) {
        Car car = carTableView.getSelectionModel().getSelectedItem();
        FormCarController controller = (FormCarController) formCarView.getController();
        controller.setCarsFromTable(carData);
        controller.setSelectedCar(car);
        Stage stage = handler.newStage(formCarView);
        stage.showAndWait();
    }

    @FXML
    public void addRent(ActionEvent event) {
        FormRentController controller = (FormRentController) formRentView.getController();
        controller.setRentsFromTable(rentData);
        controller.clear();
        Stage stage = handler.newStage(formRentView);
        stage.showAndWait();
    }

    @FXML
    public void removeRent(ActionEvent event) {
        Rent rent = rentTableView.getSelectionModel().getSelectedItem();
        rentService.delete(rent);
        rentTableView.getItems().remove(rent);
    }

    @FXML
    public void updateRent(ActionEvent event) {
        Rent rent = rentTableView.getSelectionModel().getSelectedItem();
        FormRentController controller = (FormRentController) formRentView.getController();
        controller.setRentsFromTable(rentData);
        controller.setSelectedRent(rent);
        Stage stage = handler.newStage(formRentView);
        stage.showAndWait();
    }

    @FXML
    public void logOut(ActionEvent event) {
        handler.nextScene(event, homeView);
    }

    @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() {
        carData = handler.initCarTable(carTableView, carService);
        rentData = handler.initRentTable(rentTableView, rentService);
    }
}
