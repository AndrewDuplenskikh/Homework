package duplenskikh.homework.abstract_classes;

public class SUV extends Car {
    private String clearance; //клиренс - дорожный просвет

    public void goOffroad() {
        System.out.println("Внедорожник топит по лесу!");
    }

    public String getClearance() {
        return clearance;
    }

    public void setClearance(String crearance) {
        this.clearance = crearance;
    }

    @Override
    public void gas() {
        System.out.println("Внедорожник газует!");
    }

    @Override
    public void brake() {
        System.out.println("Внедорожник тормозит!");
    }
}
