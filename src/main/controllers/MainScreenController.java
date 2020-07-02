package main.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import main.classes.Constans;
import main.classes.Part;
import main.classes.Screen;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {

    private ArrayList<Button> sideMenuButtons;
    private ArrayList<Screen> screens;
    private int actualScreen, actualScreenPart, screenLimit, screenSideMenuCont;
    private Boolean isScreenSelectedItem;

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

        screens = new ArrayList<>();

        sideMenuButtons = new ArrayList<>(Arrays.asList(btnMenuDominio, btnMenuMalla, btnMenuCondiciones, btnMenuTabla,
                btnMenuModelo, btnMenuPaso1, btnMenuPaso2,btnMenuPaso3,btnMenuPaso4,btnMenuPaso5,btnMenuPaso6,
                btnMenuMatrices,btnMenuEnsamblaje, btnMenuAplicacionConds));

        actualScreen = 0;
        actualScreenPart =0;
        screenLimit = Constans.getScreensQty();
        screenSideMenuCont = 0;
        isScreenSelectedItem = false;

        initStep("Paso 1","paso1.png");

    }

    @FXML
    public void nextStep () {

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

    }
    @FXML
    public void backSubStep () {

    }

    public ArrayList<Part> initParts(String... imgs) {
        ArrayList<Part> parts = new ArrayList<>();
        for(String i : imgs) {
            parts.add(new Part(i));
        }
        return parts;
    }

    public void initStep(String title, String imgLogoName) {
        ArrayList<Part> parts;
        parts = initParts();
        Screen screen = new Screen(title,imgLogoName,parts);
        screens.add(screen);
    }

    @FXML
    public void menuItemSelected (ActionEvent event) throws Exception {
        screenSideMenuCont =0;
        isScreenSelectedItem = false;
        for (Button menuButton : sideMenuButtons) {

            if(!isScreenSelectedItem) screenSideMenuCont++;

            if (event.getSource() == menuButton) {
                menuButton.getStyleClass().removeAll("button5", "button5-selected");
                menuButton.getStyleClass().add("button5-selected");
                isScreenSelectedItem =true;
            } else {
                menuButton.getStyleClass().removeAll("button5", "button5-selected");
                menuButton.getStyleClass().add("button5");
            }
        }
        actualScreen = screenSideMenuCont -1;
        System.out.println(screenSideMenuCont);
        System.out.println(actualScreen);
    }
}
