package duplenskikh.homework.oop;

import java.util.Arrays;

public class Company implements IdealCompany {
    private Worker[] staff;
    private String name;

    public Company(String name) {
        this.name = name;
        this.staff = new Worker[0];
    }

    @Override
    public void addEmployee(Worker newEmployee, int salary) {
        if (existsByName(newEmployee.getName())) {
            throw new PersonBelongsStaffException("This person is already in staff!");
        }
        newEmployee.salaryValidate(salary);
        staff = Arrays.copyOf(staff, staff.length + 1);
        staff[staff.length - 1] = newEmployee;
        newEmployee.setCompanyName(this.getName());
        newEmployee.setSalary(salary);
    }

    @Override
    public void removeEmployee(Worker worker) {
        if (!existsByName(worker.getName())) {
            throw new WorkerNotFoundException(String.format("Could not found worker by name: %s", worker.getName()));
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

    @Override
    public void printStaff() {
        System.out.println("Current staff list:");
        for (Worker employee : staff) {
            System.out.println(employee.getName());
        }
    }

    @Override
    public Worker employeeByName(String name) {
        for (Worker employee : staff) {
            if (employee.getName().equals(name)) return employee;
        }
        throw new WorkerNotFoundException(String.format("Could not found worker by name: %s", name));
    }

    //метод нам не очень нравится, но мы хотим показать знания try/catch (С) Федор
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
