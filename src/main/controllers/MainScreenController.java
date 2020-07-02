package main.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import main.classes.Constans;
import main.classes.Step;

import java.net.URL;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {

    private int step = 0;
    private int subStep = 0;
    private int subStepLimit = 5;
    private int stepLimit = 7;

    @FXML
    ImageView ivStep;
    @FXML
    Text txtStep, txtStepNumber, txtStepPartNumber;
    @FXML
    Button btnMenuHome, btnBackSubStep, btnNextSubStep, btnMenuModel, btnMenuS2, btnMenuS3,
            btnMenuS4, btnMenuS5, btnFooterNextAll, btnFooterNext,btnFooterHome,
            btnFooterBack,btnFooterBackAll;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void nextStep () {
        step++;
        txtStep.setText("Estas en el paso: "+step);
        txtStepNumber.setText("Paso: "+step);
        subStep = 0;
        txtStepPartNumber.setText("Sub Step: "+subStep);
    }

    @FXML
    public void prevStep () {

    }
    @FXML
    public void backAll () {

    }
    @FXML
    public void nextAll() {

    }
    @FXML
    public void goHome () {

    }
    @FXML
    public void nextSubStep () {
        subStep++;
        txtStepPartNumber.setText("SubStep: "+subStep);

    }
    @FXML
    public void backSubStep () {

    }
    @FXML
    public void menuItemSelected () {
        btnMenuHome.getStyleClass().remove("button5");
        btnMenuHome.getStyleClass().add("button5-selected");

    }
}
