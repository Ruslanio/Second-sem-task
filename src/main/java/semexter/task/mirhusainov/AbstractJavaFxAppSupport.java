package semexter.task.mirhusainov;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by Ruslan on 22.05.2017.
 */
public class AbstractJavaFxAppSupport extends Application {

    private ConfigurableApplicationContext context;
    private static String[] args;

    public static void setArgs(String[] args) {
        AbstractJavaFxAppSupport.args = args;
    }

    @Override
    public void init() throws Exception {
        context = SpringApplication.run(getClass(),args);
        context.getAutowireCapableBeanFactory().autowireBean(this);
    }

    @Override
    public void stop() throws Exception {
        context.close();
        super.stop();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }

    public static void launchApp(Class<? extends AbstractJavaFxAppSupport> certainClass, String[] args){
        AbstractJavaFxAppSupport.setArgs(args);
        Application.launch(certainClass,args);
    }
}
