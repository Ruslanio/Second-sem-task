package semexter.task.mirhusainov.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by Ruslan on 22.05.2017.
 */
public class HomeController {


    @Autowired
    AuthenticationManager authManager;
    @FXML
    private TextField et_login;
    @FXML
    private PasswordField et_password;

    @FXML
    public void login(ActionEvent event){
        String login = et_login.getText();
        String password = et_password.getText();


        Authentication authentication = new UsernamePasswordAuthenticationToken(login,password);
        authentication = authManager.authenticate(authentication);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        GrantedAuthority adminAuthority = new SimpleGrantedAuthority("ADMIN_ROLE");
        if (authentication.getAuthorities().contains(adminAuthority)){

        } else {

        }
    }

    @FXML
    public void toReg(ActionEvent event){

    }

}
