package duplenskikh.homework.oop;

/*
1.Создать интерфейс Worker и IdealCompany;
2.Минимум 2 имплементации: сделать классы Person и Manager и имплементировать интерфейс Worker;
3.Сделать так, чтобы класс Company работал именно с интерфейсом;
4.Публичные методы, что есть в Company, вынести в интерфейс IdealCompany.
5.Создать один дефолтный метод
*/

public class Main {
    public static void main(String[] args) {
        try {
            Person adam = new Person("adam", 22);
            Manager eva = new Manager("eva", 18);
            Person snake = new Person("snake", 999);
            Company google = new Company("Google");

            google.addEmployee(adam, 2000);
            google.addEmployee(eva, 1000);
            System.out.println(adam.getCompanyName());
            google.printStaff();
            google.removeEmployee(eva);
            System.out.println(eva.getCompanyName());
            google.addEmployee(adam, 2000);
            google.printStaff();
            google.removeEmployee(eva);
            google.addEmployee(snake, 666);
            google.printStaff();
            eva.greeting();
            adam.greeting();
        } catch (PersonBelongsStaffException | SalaryValidateException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
