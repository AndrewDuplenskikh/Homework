package duplenskikh.homework.oop;

public class Manager implements Worker{
    private String name;
    private int age;
    private int salary;
    private String companyName;

    public Manager(String name, int age) {
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
        System.out.println("Hello world, my name is " + this.name + ".I'm MANAGER");
    }

    @Override
    public void setCompanyName(String name) {
        this.companyName = companyName;
    }

    @Override
    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public void printName() {
        System.out.println(this.name);
    }

    public String getName() {
        return this.name;
    }

    public String getCompanyName() {
        return this.companyName;
    }
}
