package vn.techmaster.project01.model;

public class BMI {
    private double weight;
    private double height;

    public BMI() {
    }
    
    public BMI(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
}
