package duplenskikh.homework.oop;

import java.util.Arrays;

public class Company {
    private Person[] staff;
    private String name;

    public Company(String name) {
        this.name = name;
        this.staff = new Person[0];
    }

    public void addEmployee(Person newEmployee, int salary) {
        try {
            if (isPersonBelongsStaff(newEmployee)) {
                throw new IsPersonBelongsStaffException("This person is already in staff!");
            }
            newEmployee.salaryValidate(salary);
            staff = Arrays.copyOf(staff, staff.length + 1);
            staff[staff.length - 1] = newEmployee;
            newEmployee.setCompanyName(this.getName());
            newEmployee.setSalary(salary);
        } catch (SalaryValidateException | IsPersonBelongsStaffException exception) {
            System.out.println(exception);
        }
    }

    public void removeEmployee(Person person) {
        try {
            if (!isPersonBelongsStaff(person)) {
                throw new IsPersonBelongsStaffException("This person is out of staff!");
            }
            Person[] newStaff = new Person[staff.length - 1];
            int newStaffIndex = 0;
            for (int i = 0; i < staff.length; i++) {
                if (!staff[i].equals(person)) {
                    newStaff[newStaffIndex] = staff[i];
                    newStaffIndex++;
                }
            }
            staff = newStaff;
            person.setCompanyName("");
            person.setSalary(0);
        } catch (IsPersonBelongsStaffException exception) {
            System.out.println(exception);
        }
    }

    private boolean isPersonBelongsStaff(Person person) {
        for (Person employee: staff) {
            if (employee.equals(person)) {
                return true;
            }
        }
        return false;
    }

    public void printStaff() {
        System.out.println("Current staff list:");
        for (Person employee: staff) {
            System.out.println(employee.getName());
        }
    }

    public String getName() {
        return name;
    }
}
