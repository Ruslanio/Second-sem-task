package semexter.task.mirhusainov.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import semexter.task.mirhusainov.config.MainConfig;
import semexter.task.mirhusainov.controller.util.SceneChangesHandler;
import semexter.task.mirhusainov.model.Car;
import semexter.task.mirhusainov.service.CarService;
import semexter.task.mirhusainov.service.RentService;

import javafx.event.ActionEvent;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Ruslan on 23.05.2017.
 */
public class RegularUserController {

    SceneChangesHandler handler;

    public RegularUserController() {
        handler = SceneChangesHandler.getInstance();
    }

    @Autowired
    private MainConfig.View formRentView;

    @Autowired
    private MainConfig.View homeView;
    @FXML
    private TableView<Car> tableView;

    @Autowired
    private CarService carService;

    @Autowired
    private RentService rentService;

    @FXML
    public void initialize() {
    }

    @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() {
        handler.initCarTable(tableView, carService);
    }

    @FXML
    public void rentCar(ActionEvent event) {
        String mark = null;
        try {
            mark = tableView.getSelectionModel().getSelectedItem().getMark();
        } catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Choose the car");
            alert.show();
            return;
        }
        FormRentController controller = (FormRentController) formRentView.getController();
        controller.setModel(mark);
        Stage stage = handler.newStage(formRentView);
        stage.showAndWait();
    }

    @FXML
    public void logOut(ActionEvent event) {
        handler.nextScene(event, homeView);
    }
}
