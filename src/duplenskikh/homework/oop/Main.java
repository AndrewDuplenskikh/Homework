package duplenskikh.homework.oop;

/*
1. создать 1 статичное поле любого типа String попробовать поменять
его у Боба и у Алекса; String companyName.
-  Должен быть статичный метод, который работает с этим полем.
2. Написать метод в этом классе, который проверяет,
что зарплата не меньше, чем возраст - этот метод должен возвращать boolean.
3. Написать метод salaryValidate, который
вызывает метод из пункта 2 и выкидывает исключения, если проверка не проходит.
4. Написать класс Company, который хранит массив person и позволяет добавлять новых person
(методы должны называться типа "принять на работу" и "уволить").
5. Класс Company должен иметь метод, который напечатает всех работников.
У Company должен быть field name.
*/

public class Main {
    public static void main(String[] args) {
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
    }
}
