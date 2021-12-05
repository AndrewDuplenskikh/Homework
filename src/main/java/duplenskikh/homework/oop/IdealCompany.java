package duplenskikh.homework.oop;

public interface IdealCompany {

    /**
     *
     * Метод найма нового работника
     * @param newEmployee новый работник
     * @param salary зарплата
     * @throws PersonBelongsStaffException
     * @throws SalaryValidateException
     */
    void addEmployee(AbstractWorker newEmployee, int salary) throws IsPersonBelongsStaffException, SalaryValidateException;


    /**
     *
     * Метод увольнения работника
     * @param worker увольняемый работник
     * @throws PersonBelongsStaffException
     */
    void removeEmployee(AbstractWorker worker) throws IsPersonBelongsStaffException;


    /**
     *
     * Метод для вывода текущего штата компании
     */
    void printStaff();

    /**
     *
     * @param name - имя работника
     * @return возвращается работник
     */
    Worker employeeByName(String name);
}
