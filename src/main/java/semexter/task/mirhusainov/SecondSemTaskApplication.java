package semexter.task.mirhusainov;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;
import semexter.task.mirhusainov.config.MainConfig;

import java.io.InputStream;

@Lazy
@SpringBootApplication
public class SecondSemTaskApplication extends AbstractJavaFxAppSupport {

	@Value("Car Rental")
	private String title;

	@Autowired
	@Qualifier("homeView")
	private MainConfig.View homeView;

	public static void main(String[] args) {
		launchApp(SecondSemTaskApplication.class, args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle(title);
		primaryStage.setResizable(true);
  		primaryStage.setScene(new Scene(homeView.getView()));
		primaryStage.show();
	}
}
