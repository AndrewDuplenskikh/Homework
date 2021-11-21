package duplenskikh.homework.oop;

public class Person extends AbstractWorker{

    public Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    @Override
    public void salaryValidate(int salary) throws SalaryValidateException {
        if (isAgeGreaterThanSalary(salary)) {
            throw new SalaryValidateException("Age is greater than salary!");
        }
    }
}
