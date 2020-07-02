package main.controllers;

import com.sun.xml.internal.bind.v2.TODO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
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
    private int actualScreen, actualScreenPart, screenLimit, screenSelectedCont, lastMenuItemChanged;
    private Boolean isScreenSelectedItem;

    @FXML
    Text txtActualScreenName;

    @FXML
    ImageView ivActualScreen;

    @FXML
    Button btnMenuDominio, btnMenuMalla, btnMenuCondiciones, btnMenuTabla, btnMenuModelo, btnMenuPaso1,
            btnMenuPaso2,btnMenuPaso3,btnMenuPaso4,btnMenuPaso5,btnMenuPaso6,btnMenuMatrices,btnMenuEnsamblaje,
            btnMenuAplicacionConds,

            btnFooterBackAll, btnFooterBack, btnFooterHome, btnFooterNext, btnFooterNextAll, btnBackScreenPart, btnNextScreenPart;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        screens = new ArrayList<>();

        sideMenuButtons = new ArrayList<>(Arrays.asList(btnMenuDominio, btnMenuMalla, btnMenuCondiciones, btnMenuTabla,
                btnMenuModelo, btnMenuPaso1, btnMenuPaso2,btnMenuPaso3,btnMenuPaso4,btnMenuPaso5,btnMenuPaso6,
                btnMenuMatrices,btnMenuEnsamblaje, btnMenuAplicacionConds));

        actualScreen = 0;
        actualScreenPart =0;
        screenLimit = Constans.getScreensQty();
        lastMenuItemChanged=0;
        screenSelectedCont = 0;
        isScreenSelectedItem = false;

        initScreen("Paso 1","paso1.png","hola", "mundo2");
        initScreen("Paso 2","paso2.png","hola", "mundo2");
        initScreen("Paso 3","paso3.png","hola", "mundo2");
        initScreen("Paso 4","paso4.png","hola", "mundo2");
        initScreen("Paso 5","paso5.png","hola", "mundo2");
        initScreen("Paso 6","paso6.png","hola", "mundo2");
        initScreen("Paso 7","paso7.png","hola", "mundo2");
        initScreen("Paso 8","paso8.png","hola", "mundo2");
        initScreen("Paso 9","paso9.png","hola", "mundo2");
        initScreen("Paso 10","paso10.png","hola", "mundo2");
        initScreen("Paso 11","paso11.png","hola", "mundo2");
        initScreen("Paso 12","paso12.png","hola", "mundo2");
        initScreen("Paso 13","paso13.png","hola", "mundo2");
        initScreen("Paso 14","paso14.png","hola", "mundo2");

        setupViewComponents();
    }

    @FXML
    public void backAll (ActionEvent event) throws Exception {

    }

    @FXML
    public void backScreen (ActionEvent event) throws Exception {
        lastMenuItemChanged=actualScreen;
        if (actualScreen > 0) {
            actualScreen--;
            actualScreenPart = 0;
        }
        setupViewComponents();
        fixMenuItemSelected();
    }

    @FXML
    public void goHome (ActionEvent event) throws Exception {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../views/start.fxml"));
        Scene scene = new Scene(root, Constans.getWIDTH(), Constans.getHEIGHT());
        stage.setScene(scene);
    }

    @FXML
    public void nextScreen(ActionEvent event) throws Exception {
        lastMenuItemChanged=actualScreen;
        if (actualScreen < screens.size()-1) {
            actualScreen++;
            actualScreenPart = 0;
        }
        setupViewComponents();
        fixMenuItemSelected();
    }

    @FXML
    public void nextAll(ActionEvent event) throws Exception {

    }

    public ArrayList<Part> initParts(String... imgs) {
        ArrayList<Part> parts = new ArrayList<>();
        for(String i : imgs) {
            parts.add(new Part(i));
        }
        return parts;
    }

    public void initScreen(String title, String imgLogoName, String ...stepImgNames) {
        ArrayList<Part> parts;
        parts = initParts(stepImgNames);
        Screen screen = new Screen(title,imgLogoName,parts);
        screens.add(screen);
    }

    @FXML
    public void menuItemSelected (ActionEvent event) throws Exception {
        lastMenuItemChanged=actualScreen;
        screenSelectedCont =0;
        isScreenSelectedItem = false;
        for (Button menuButton : sideMenuButtons) {
            if(!isScreenSelectedItem) screenSelectedCont++;
            if (event.getSource() == menuButton) {
                isScreenSelectedItem =true;
                break;
            }
        }
        actualScreen = screenSelectedCont -1;
        setupViewComponents();
        fixMenuItemSelected();
    }

    public void fixMenuItemSelected () {
        //Normaliza el color del menu de la ultima pantalla seleccionada
        System.out.println("Pantalla anterior: "+lastMenuItemChanged);

        sideMenuButtons.get(lastMenuItemChanged).getStyleClass().removeAll("button5", "button5-selected");
        sideMenuButtons.get(lastMenuItemChanged).getStyleClass().add("button5");

        //Muestra la seleccion de la pantalla actual

        System.out.println("Pantalla actual: "+actualScreen);
        sideMenuButtons.get(actualScreen).getStyleClass().removeAll("button5", "button5-selected");
        sideMenuButtons.get(actualScreen).getStyleClass().add("button5-selected");
    }

    public void setupViewComponents() {
        //TODO: configurar la visivilidad de lo botones
        txtActualScreenName.setText(screens.get(actualScreen).getTitle());
    }
}
