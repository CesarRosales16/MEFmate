package main.classes;

import java.util.ArrayList;

public class Screen {
    private String title;
    private String screenLogoName;
    private ArrayList<Part> screenParts; //El minimo seria 1 (index 0)

    public Screen(String title, String screenLogoName, ArrayList<Part> screenParts) {
        this.title = title;
        this.screenLogoName = screenLogoName;
        this.screenParts = screenParts;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getScreenLogoName() {
        return screenLogoName;
    }

    public void setScreenLogoName(String screenLogoName) {
        this.screenLogoName = screenLogoName;
    }

    public ArrayList<Part> getScreenParts() {
        return screenParts;
    }

    public void setScreenParts(ArrayList<Part> screenParts) {
        this.screenParts = screenParts;
    }
}
