package main.classes;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Step {
    private int idStep;
    private String name;
    private ImageView stepIcon;
    private ArrayList<SubStep> subSteps;

    public Step(int idStep, String name, ImageView stepIcon, ArrayList<SubStep> subSteps) {
        this.idStep = idStep;
        this.name = name;
        this.stepIcon = stepIcon;
        this.subSteps = subSteps;
    }

    public int getIdStep() {
        return idStep;
    }

    public void setIdStep(int idStep) {
        this.idStep = idStep;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ImageView getStepIcon() {
        return stepIcon;
    }

    public void setStepIcon(ImageView stepIcon) {
        this.stepIcon = stepIcon;
    }

    public ArrayList<SubStep> getSubSteps() {
        return subSteps;
    }

    public void setSubSteps(ArrayList<SubStep> subSteps) {
        this.subSteps = subSteps;
    }
}
