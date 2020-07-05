package main.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import main.classes.Constans;

import javax.swing.text.html.ImageView;
import java.net.URL;
import java.util.ResourceBundle;


public class InstructionsController implements Initializable {

    @FXML
    ImageView ivManual;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void iniciar(ActionEvent event) throws Exception {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/main/views/mainScreen.fxml"));
        Scene scene = new Scene(root, Constans.getWIDTH(), Constans.getHEIGHT());
        stage.setScene(scene);
    }

    @FXML
    public void goHome(ActionEvent event) throws Exception{
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/main/views/start.fxml"));
        Scene scene = new Scene(root, Constans.getWIDTH(), Constans.getHEIGHT());
        stage.setScene(scene);
    }
}
