package main.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.classes.Constans;

import java.net.URL;
import java.util.ResourceBundle;

public class FinishController implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void backHome(ActionEvent event) throws Exception{
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/main/views/start.fxml"));
        Scene scene = new Scene(root, Constans.getWIDTH(), Constans.getHEIGHT());
        stage.setScene(scene);
    }
}
