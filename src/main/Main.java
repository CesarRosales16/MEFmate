package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import main.classes.Constans;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("views/start.fxml"));
        primaryStage.setTitle("MEFmate");
        Scene scene = new Scene(root, Constans.getWIDTH(), Constans.getHEIGHT());
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("main/resources/img/icons/MEFmate-icon.png"));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
