package duplenskikh.homework.oop;

public interface IdealCompany {

    /**
     *
     * Метод найма нового работника
     * @param newEmployee новый работник
     * @param salary зарплата
     * @throws IsPersonBelongsStaffException
     * @throws SalaryValidateException
     */
    void addEmployee(Worker newEmployee, int salary) throws IsPersonBelongsStaffException, SalaryValidateException;

    /**
     *
     * Метод увольнения работника
     * @param worker увольняемый работник
     * @throws IsPersonBelongsStaffException
     */
    void removeEmployee(Worker worker) throws IsPersonBelongsStaffException;

    /**
     *
     * Метод для вывода текущего штата компании
     */
    void printStaff();
}