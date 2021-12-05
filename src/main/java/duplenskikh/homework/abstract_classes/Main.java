package duplenskikh.homework.abstract_classes;

public class Main {
    public static void main(String[] args) {
        Car jeep = new SUV();
        jeep.gas();
        jeep.brake();
        System.out.println(); //для переноса строки
        Car nissan = new Sedan();
        nissan.gas();
        nissan.brake();
//        nissan.drift();
        System.out.println(); //для переноса строки
        Sedan lada = new Sedan();
        lada.gas();
        lada.brake();
        lada.drift();
        System.out.println(); //для переноса строки
        Car [] parking = new Car[3];
        parking[0] = jeep;
        parking[1] = nissan;
        parking[2] = lada;
        for (Car car:parking) {
            car.gas();
        }
    }
}
