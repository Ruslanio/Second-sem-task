package semexter.task.mirhusainov.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import semexter.task.mirhusainov.config.MainConfig;
import semexter.task.mirhusainov.controller.util.SceneChangesHandler;
import semexter.task.mirhusainov.model.User;
import semexter.task.mirhusainov.service.UserService;
import semexter.task.mirhusainov.util.Validator;

/**
 * Created by Ruslan on 22.05.2017.
 */
public class RegistrationController {

    private SceneChangesHandler handler;

    @Autowired
    @Qualifier("homeView")
    private MainConfig.View homeView;

    @Autowired
    private UserService userService;

    public RegistrationController() {
        handler = SceneChangesHandler.getInstance();
    }

    @Autowired
    private Validator validator;

    @FXML
    private TextField et_reg_login;

    @FXML
    private PasswordField et_reg_password;

    @FXML
    private PasswordField et_reg_password_confirm;


    @FXML
    public void register(ActionEvent event){
        String login = et_reg_login.getText();
        String pass = et_reg_password.getText();
        String confirm = et_reg_password_confirm.getText();

        try {
            validator.isRegistrationValid(login,pass,confirm);
            userService.save(new User(login,pass));
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"you are successfully registered");
            alert.show();
            handler.nextScene(event,homeView);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR,e.getMessage());
            alert.show();
        }
    }

    @FXML
    public void toLog(ActionEvent event){
        handler.nextScene(event,homeView);
    }
}
