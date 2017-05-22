package semexter.task.mirhusainov.config;

import javafx.fxml.FXMLLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import semexter.task.mirhusainov.controller.HomeController;
import semexter.task.mirhusainov.controller.RegistrationController;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Ruslan on 22.05.2017.
 */
@Configuration
public class MainConfig {

    private static final String homePath = "resources/home.fxml";
    private static final String registrationPath = "resources/registration.fxml";

    @Bean
    public HomeController getHomeController() throws IOException {
        return getFXML(homePath).getController();
    }

    @Bean
    public RegistrationController getRegistrationController() throws IOException {
        return getFXML(registrationPath).getController();
    }

    private FXMLLoader getFXML(String path) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        try {

            InputStream stream = getClass().getClassLoader().getResourceAsStream(path);
            loader.load(stream);
            stream.close();
        } catch (IOException e){
            System.err.println("FXMLLoader error");
            return null;
        }
        return loader;
    }
}
