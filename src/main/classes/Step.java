package main.classes;

public class Step {
    private int step;
    private int subStep;

    public Step(int step, int subStep) {
        this.step = step;
        this.subStep = subStep;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getSubStep() {
        return subStep;
    }

    public void setSubStep(int subStep) {
        this.subStep = subStep;
    }
}
