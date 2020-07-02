package main.controllers;

import javafx.event.ActionEvent;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {

    private ArrayList<Button> sideMenuButtons;
    private int step = 0;
    private int subStep = 0;
    private int subStepLimit;
    private int stepLimit;

    @FXML
    ImageView ivStep;
    @FXML
    Text txtStep, txtStepNumber, txtStepPartNumber;
    @FXML
    Button btnMenuDominio, btnMenuMalla, btnMenuCondiciones, btnMenuTabla, btnMenuModelo, btnMenuPaso1,
            btnMenuPaso2,btnMenuPaso3,btnMenuPaso4,btnMenuPaso5,btnMenuPaso6,btnMenuMatrices,btnMenuEnsamblaje,
            btnMenuAplicacionConds,

            btnBackSubStep, btnNextSubStep, btnFooterNextAll, btnFooterNext,btnFooterHome,
            btnFooterBack,btnFooterBackAll;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        sideMenuButtons = new ArrayList<>(Arrays.asList(btnMenuDominio, btnMenuMalla, btnMenuCondiciones, btnMenuTabla,
                btnMenuModelo, btnMenuPaso1, btnMenuPaso2,btnMenuPaso3,btnMenuPaso4,btnMenuPaso5,btnMenuPaso6,
                btnMenuMatrices,btnMenuEnsamblaje, btnMenuAplicacionConds));

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
    public void menuItemSelected2 (ActionEvent event) throws Exception {
        for (Button menuButton: sideMenuButtons) {
            if(event.getSource()==menuButton) {
                menuButton.getStyleClass().removeAll("button5","button5-selected");
                menuButton.getStyleClass().add("button5-selected");
            } else {
                menuButton.getStyleClass().removeAll("button5","button5-selected");
                menuButton.getStyleClass().add("button5");
            }
        }
    }
    @FXML
    public void menuItemSelected (ActionEvent event) throws Exception {
        for (Button menuButton : sideMenuButtons) {
            System.out.println(menuButton.toString());
            if (event.getSource() == menuButton) {
                menuButton.getStyleClass().removeAll("button5", "button5-selected");
                menuButton.getStyleClass().add("button5-selected");
            } else {
                menuButton.getStyleClass().removeAll("button5", "button5-selected");
                menuButton.getStyleClass().add("button5");
            }
        }
    }
}
