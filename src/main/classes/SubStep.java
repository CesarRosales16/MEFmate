package main.classes;

import javafx.scene.image.ImageView;

public class SubStep {
    private int idSubStep;
    private ImageView ivSubStep;

    public SubStep(int idSubStep, ImageView ivSubStep) {
        this.idSubStep = idSubStep;
        this.ivSubStep = ivSubStep;
    }

    public int getIdSubStep() {
        return idSubStep;
    }

    public void setIdSubStep(int idSubStep) {
        this.idSubStep = idSubStep;
    }

    public ImageView getIvSubStep() {
        return ivSubStep;
    }

    public void setIvSubStep(ImageView ivSubStep) {
        this.ivSubStep = ivSubStep;
    }
}
