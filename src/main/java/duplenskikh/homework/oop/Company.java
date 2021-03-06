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
    public void addEmployee(AbstractWorker newEmployee, int salary) {
        if (isPersonBelongsStaff(newEmployee)) {
            throw new PersonBelongsStaffException("This person is already in staff!");
        }
        newEmployee.salaryValidate(salary);
        staff = Arrays.copyOf(staff, staff.length + 1);
        staff[staff.length - 1] = newEmployee;
        newEmployee.setCompanyName(this.getName());
        newEmployee.setSalary(salary);
    }

    @Override
    public void removeEmployee(AbstractWorker worker) {
        if (!isPersonBelongsStaff(worker)) {
            throw new WorkerNotFoundException("This person is out of staff!");
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

    public AbstractWorker getEmployeeByIndex(int index) {
        return staff[index];
    }

    @Override
    public void printStaff() {
        System.out.println("Current staff list:");
        for (AbstractWorker employee: staff) {
            System.out.println(employee.getName());
        }
    }

    @Override
    public AbstractWorker employeeByName(String name) {
        for (AbstractWorker employee : staff) {
            if (employee.getName().equals(name)) return employee;
        }
        throw new WorkerNotFoundException(String.format("Could not found worker by name: %s", name));
    }

    //?????????? ?????? ???? ?????????? ????????????????, ???? ???? ?????????? ???????????????? ???????????? try/catch (??) ??????????
    private boolean existsByName(String name) {
        try {
            employeeByName(name);
            return true;
        } catch (WorkerNotFoundException exception) {
            return false;
        }
    }

    public String getName() {
        return name;
    }
}
