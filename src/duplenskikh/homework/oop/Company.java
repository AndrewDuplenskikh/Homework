package duplenskikh.homework.oop;

import java.util.Arrays;

public class Company implements IdealCompany{
    private Worker[] staff;
    private String name;

    public Company(String name) {
        this.name = name;
        this.staff = new Worker[0];
    }

    @Override
    public void addEmployee(Worker newEmployee, int salary) throws IsPersonBelongsStaffException, SalaryValidateException {
        if (isPersonBelongsStaff(newEmployee)) {
            throw new IsPersonBelongsStaffException("This person is already in staff!");
        }
        newEmployee.salaryValidate(salary);
        staff = Arrays.copyOf(staff, staff.length + 1);
        staff[staff.length - 1] = newEmployee;
        newEmployee.setCompanyName(this.getName());
        newEmployee.setSalary(salary);
    }

    @Override
    public void removeEmployee(Worker worker) throws IsPersonBelongsStaffException {
        if (!isPersonBelongsStaff(worker)) {
            throw new IsPersonBelongsStaffException("This person is out of staff!");
        }
        Worker[] newStaff = new Worker[staff.length - 1];
        int newStaffIndex = 0;
        for (int i = 0; i < staff.length; i++) {
            if (staff[i].equals(worker)) {
                continue;
            }
            newStaff[newStaffIndex] = staff[i];
            newStaffIndex++;
        }
        staff = newStaff;
        worker.setCompanyName("");
        worker.setSalary(0);
    }

    private boolean isPersonBelongsStaff(Worker worker) {
        for (Worker employee: staff) {
            if (employee.equals(worker)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void printStaff() {
        System.out.println("Current staff list:");
        for (Worker employee: staff) {
            System.out.println(employee.getName());
        }
    }

    public String getName() {
        return name;
    }
}
