package duplenskikh.homework.oop;

public class Person {
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

    public void salaryValidate(int salary) throws SalaryValidateException {
        if (!isSalaryGreaterThanAge(salary)) {
            throw new SalaryValidateException("Age is greater than salary!");
        }
    }

    public String getName() {
        return name;
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

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
