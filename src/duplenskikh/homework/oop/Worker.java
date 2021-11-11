package duplenskikh.homework.oop;

public interface Worker {
    void salaryValidate(int salary) throws SalaryValidateException;

    void greeting();

    void setCompanyName(String name);

    void setSalary(int salary);

    String getName();
}
