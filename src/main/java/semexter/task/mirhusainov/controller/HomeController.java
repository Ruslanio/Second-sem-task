package semexter.task.mirhusainov.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import semexter.task.mirhusainov.config.MainConfig;
import semexter.task.mirhusainov.controller.util.SceneChangesHandler;
import semexter.task.mirhusainov.util.Validator;

/**
 * Created by Ruslan on 22.05.2017.
 */
public class HomeController {

    private static final String ADMIN_LOGIN = "admin";
    private SceneChangesHandler handler;

    public HomeController() {
        handler = SceneChangesHandler.getInstance();
    }

    @Autowired
    @Qualifier("registrationView")
    private MainConfig.View registrationView;
    @FXML
    private TextField et_login;
    @FXML
    private PasswordField et_password;

    @Autowired
    private Validator validator;

    @Autowired
    @Qualifier("adminView")
    private MainConfig.View adminView;

    @Autowired
    @Qualifier("regularUserView")
    private MainConfig.View regularUserView;

    @FXML
    public void login(ActionEvent event){
        String login = et_login.getText();
        String password = et_password.getText();
        try {
            validator.isAuthValid(login,password);
            if (login.equals(ADMIN_LOGIN)){
                handler.nextScene(event,adminView);
            } else {
                handler.nextScene(event,regularUserView);
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR,e.getMessage());
            alert.show();
        }

    }

    @FXML
    public void toReg(ActionEvent event){
        handler.nextScene(event,registrationView);
    }

}
