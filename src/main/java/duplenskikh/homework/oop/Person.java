package duplenskikh.homework.oop;

public class Person implements Worker{
    private String name;
    private int age;
    private int salary;
    private String companyName;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private boolean isSalaryGreaterThanAge(int salary) {
        return salary > this.age;
    }

    @Override
    public void salaryValidate(int salary) throws SalaryValidateException {
        if (!isSalaryGreaterThanAge(salary)) {
            throw new SalaryValidateException("Age is greater than salary!");
        }
    }

    @Override
    public void greeting() {
        System.out.println("Hello world, my name is " + this.name + ".Im PERSON");
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public void printName() {
        System.out.println(this.name);
    }

    public String getCompanyName() {
        return this.companyName;
    }

    @Override
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
