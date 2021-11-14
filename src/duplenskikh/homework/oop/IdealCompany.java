package duplenskikh.homework.oop;

public interface IdealCompany {
    void addEmployee(Worker newEmployee, int salary) throws IsPersonBelongsStaffException, SalaryValidateException;

    void removeEmployee(Worker worker) throws IsPersonBelongsStaffException;

    void printStaff();
}
