package semexter.task.mirhusainov.config;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import semexter.task.mirhusainov.controller.*;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Ruslan on 22.05.2017.
 */
@Configuration
public class MainConfig {

    private static final String homePath = "views/home.fxml";
    private static final String registrationPath = "views/registration.fxml";
    private static final String adminPath = "views/admin.fxml";
    private static final String regularUserPath = "views/regularUser.fxml";
    private static final String formCarPath = "views/formCar.fxml";
    private static final String formRentPath = "views/formRent.fxml";

    @Bean
    public HomeController getHomeController() throws IOException {
        return (HomeController) getHomeView().getController();
    }

    @Bean
    public RegistrationController getRegistrationController() throws IOException {
        return (RegistrationController) getRegistrationView().getController();
    }

    @Bean
    public AdminController getAdminController() throws IOException {
        return (AdminController) getAdminView().getController();
    }

    @Bean
    public RegularUserController getRegularUserController() throws IOException {
        return (RegularUserController) getRegularUserView().getController();
    }

    @Bean
    public FormCarController getFormCarController() throws IOException {
        return (FormCarController) getFormCarView().getController();
    }

    @Bean
    public FormRentController getFormRentController() throws IOException {
        return (FormRentController) getFormRentView().getController();
    }

    @Bean(name = "homeView")
    public View getHomeView() throws IOException {
        return getView(homePath);
    }

    @Bean(name = "registrationView")
    public View getRegistrationView() throws IOException {
        return getView(registrationPath);
    }

    @Bean(name = "adminView")
    public View getAdminView() throws IOException {
        return getView(adminPath);
    }

    @Bean(name = "regularUserView")
    public View getRegularUserView() throws IOException {
        return getView(regularUserPath);
    }

    @Bean(name = "formCarView")
    public View getFormCarView() throws IOException {
        return getView(formCarPath);
    }

    @Bean(name = "formRentView")
    public View getFormRentView() throws IOException {
        return getView(formRentPath);
    }

    private View getView(String path) throws IOException {
        InputStream stream = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            stream = getClass().getClassLoader().getResourceAsStream(path);
            System.err.println(path);
            loader.load(stream);
            return new View(loader.getRoot(), loader.getController());
        } catch (IOException e) {
            System.err.println("FXMLLoader error");
            return null;
        } finally {
            if (stream != null)
                stream.close();
        }
    }

    @Getter
    @Setter
    public class View {
        private Parent view;
        private Object controller;

        public View(Parent view, Object controller) {
            this.view = view;
            this.controller = controller;
        }
    }
}
