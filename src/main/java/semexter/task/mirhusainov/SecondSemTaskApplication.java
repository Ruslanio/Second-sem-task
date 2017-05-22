package semexter.task.mirhusainov;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.InputStream;

@SpringBootApplication
public class SecondSemTaskApplication extends AbstractJavaFxAppSupport {

	@Value("Car Rental")
	private String title;

	public static void main(String[] args) {
		SpringApplication.run(SecondSemTaskApplication.class, args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		InputStream stream = getClass().getClassLoader().getResourceAsStream("resources/home.fxml");
		FXMLLoader loader = new FXMLLoader();
		loader.load(stream);
		stream.close();

		primaryStage.setTitle(title);
		primaryStage.setResizable(true);
  		primaryStage.setScene(new Scene(loader.getRoot()));
		primaryStage.show();
	}
}
