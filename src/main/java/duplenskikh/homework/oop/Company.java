package duplenskikh.homework.oop;

import java.util.Arrays;

public class Company implements IdealCompany{
    private AbstractWorker[] staff;
    private String name;

    public Company(String name) {
        this.name = name;
        this.staff = new AbstractWorker[0];
    }

    @Override
    public void addEmployee(AbstractWorker newEmployee, int salary) throws IsPersonBelongsStaffException, SalaryValidateException {
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
    public void removeEmployee(AbstractWorker worker) throws IsPersonBelongsStaffException {
        if (!isPersonBelongsStaff(worker)) {
            throw new IsPersonBelongsStaffException("This person is out of staff!");
        }
        AbstractWorker[] newStaff = new AbstractWorker[staff.length - 1];
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

    private boolean isPersonBelongsStaff(AbstractWorker worker) {
        for (AbstractWorker employee: staff) {
            if (employee.equals(worker)) {
                return true;
            }
        }
        return false;
    }

    public AbstractWorker getEmployeeByIndex(int index) throws ArrayIndexOutOfBoundsException{
        return staff[index];
    }

    @Override
    public void printStaff() {
        System.out.println("Current staff list:");
        for (AbstractWorker employee: staff) {
            System.out.println(employee.getName());
        }
    }

    public String getName() {
        return name;
    }
}
