package duplenskikh.homework.abstract_classes;

public class Sedan extends Car{
    private int capacity;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void drift() {
        System.out.println("Семёрка жигулей делает грязь!");
    }

    @Override
    public void brake() {
        System.out.println("Седан тормозит!");
    }
}
