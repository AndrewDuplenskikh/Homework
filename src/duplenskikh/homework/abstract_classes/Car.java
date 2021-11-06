package duplenskikh.homework.abstract_classes;

public abstract class Car {
    private String model;
    private String color;
    private int maxSpeed;

    public void gas() {
        System.out.println("Машина едет!");
    };

//    public abstract void gas();

    public abstract void brake();

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
