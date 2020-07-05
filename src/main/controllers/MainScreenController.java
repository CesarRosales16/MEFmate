package main.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
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

    @FXML
    VBox canvas;

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

        initScreen("Dominio","paso1.png","dominio");
        initScreen("Malla","paso2.png","malla");
        initScreen("Condiciones","paso3.png","condiciones");
        initScreen("Tabla","paso4.png","tabla", "tabla2");
        initScreen("Modelo","paso5.png","modelo");
        initScreen("Localizacion","paso6.png","paso1-1", "paso1-2","paso1-3");
        initScreen("Interpolacion","paso7.png","paso2");
        initScreen("Aproximacion","paso8.png","paso3-1", "paso3-2");
        initScreen("Residuos","paso9.png","paso4-1", "paso4-2");
        initScreen("Galerkin","paso10.png","paso5-1", "paso5-2","paso5-3","paso5-4","paso5-5");
        initScreen("Integracion","paso11.png","paso6-1", "paso6-2","paso6-3","paso6-4","paso6-5","paso6-6");
        initScreen("Matrices","paso13.png","mat0","mat1","mat2","mat3","mat4","mat5","mat6","mat7","mat8","mat9","mat10","mat11","mat12","mat13","mat14","mat15","mat16","mat17","mat18","mat19","mat20","mat21","mat22","mat23","mat24","mat25","mat26","mat27","mat28","mat29","mat30","mat31","mat32","mat33","mat34","mat35");
        initScreen("Ensamblaje","paso14.png","ensamblaje", "ensamblaje2","ensamblajeB.mp4","ensamblajeM.mp4", "ensamblajeX.mp4");
        initScreen("Dir y Neu","paso14.png","condiciones", "aplicacionConds", "aplicacionCondsNeu", "aplicacionNeumann.mp4","aplicacionCondsDir","aplicacionDirichlet1.mp4", "aplicacionDirichlet2.mp4","paso9");

        btnFooterBackAll.setDisable(true);
        btnFooterBack.setDisable(true);
        btnFooterHome.setDisable(false);
        btnFooterNext.setDisable(false);
        btnFooterNextAll.setDisable(false);
        btnNextScreenPart.setDisable(true);
        btnBackScreenPart.setDisable(true);
        setupViewComponents();
    }

    @FXML
    public void backAll (ActionEvent event) throws Exception {
        actualScreen=0;
        actualScreenPart=0;
        setupViewComponents();
    }

    @FXML
    public void backScreen (ActionEvent event) throws Exception {
        lastMenuItemChanged=actualScreen;
        if (actualScreen > 0) {
            actualScreen--;
            actualScreenPart = 0;
        }
        setupViewComponents();
    }

    @FXML
    public void goHome (ActionEvent event) throws Exception {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/main/views/start.fxml"));
        Scene scene = new Scene(root, Constans.getWIDTH(), Constans.getHEIGHT());
        stage.setScene(scene);
    }

    @FXML
    public void nextScreen(ActionEvent event) throws Exception {
        lastMenuItemChanged=actualScreen;
        actualScreen++;
        if(actualScreen==screens.size()) {
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/main/views/finish.fxml"));
            Scene scene = new Scene(root, Constans.getWIDTH(), Constans.getHEIGHT());
            stage.setScene(scene);
        }
        if (actualScreen <= screens.size()-1) {
            actualScreenPart = 0;
            setupViewComponents();
        }
    }

    @FXML
    public void nextAll(ActionEvent event) throws Exception {
        actualScreenPart=0;
        actualScreen=13;
        setupViewComponents();
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
    }

    public void fixMenuItemSelected () {

        sideMenuButtons.get(lastMenuItemChanged).getStyleClass().removeAll("button5", "button5-selected");
        sideMenuButtons.get(lastMenuItemChanged).getStyleClass().add("button5");

        System.out.println("Pantalla actual: "+actualScreen);
        sideMenuButtons.get(actualScreen).getStyleClass().removeAll("button5", "button5-selected");
        sideMenuButtons.get(actualScreen).getStyleClass().add("button5-selected");
    }

    public void fixButtons() {
        if(actualScreen==0) {
            btnFooterBackAll.setDisable(true);
            btnFooterBack.setDisable(true);
        } else {
            btnFooterBackAll.setDisable(false);
            btnFooterBack.setDisable(false);
        }
        if(actualScreen==screens.size()-1)
            btnFooterNextAll.setDisable(true);
        else {
            btnFooterNextAll.setDisable(false);
            btnFooterNext.setDisable(false);
        }

        if(actualScreenPart==0) {
            btnBackScreenPart.setDisable(true);
        } else {
            btnBackScreenPart.setDisable(false);
        }
        if(actualScreenPart==screens.get(actualScreen).getScreenParts().size()-1) {
            btnNextScreenPart.setDisable(true);
        } else {
            btnNextScreenPart.setDisable(false);
        }
    }

    @FXML
    public void prevPart(ActionEvent event) throws Exception {
        if(actualScreenPart>0){
            actualScreenPart--;
        }
        setupViewComponents();
    }

    @FXML
    public void nextPart(ActionEvent event) throws Exception {
        if (actualScreenPart < screens.get(actualScreen).getScreenParts().size()-1) {
            actualScreenPart++;
        }
        setupViewComponents();
    }

    public void setupViewComponents() {
        txtActualScreenName.setText(screens.get(actualScreen).getTitle());
        fixButtons();
        fixMenuItemSelected();
        loadResources();
    }

    public void loadResources(){
        if(actualScreenPart<=screens.get(actualScreen).getScreenParts().size()-1) {
            String name = screens.get(actualScreen).getScreenParts().get(actualScreenPart).getImgToProcess();
            if(name.contains(".mp4")) {
                MediaPlayer player = new MediaPlayer( new Media(getClass().getResource("/main/resources/img/screens/"+name).toExternalForm()));
                MediaView mediaView = new MediaView(player);
                player.setAutoPlay(true);
                mediaView.setFitWidth(700);
                mediaView.setFitHeight(450);
                canvas.getChildren().clear();
                canvas.getChildren().add(mediaView);
            } else {
                ImageView iv = new ImageView(new Image("/main/resources/img/screens/" + name + ".png"));
                iv.setFitHeight(450);
                iv.setFitWidth(700);
                iv.setPreserveRatio(true);
                canvas.getChildren().clear();
                canvas.getChildren().add(iv);
            }
        }
    }
}
