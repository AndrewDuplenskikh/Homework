package duplenskikh.homework.oop;

public interface Worker {

    /**
     *
     * Метод для проверки зп, чтобы сотрудника не нагрели на бабки
     * @param salary проверяемая зп
     * @throws SalaryValidateException
     */
    void salaryValidate(int salary) throws SalaryValidateException;

    /**
     *
     * Метод - приветствие
     */
    default void greeting() {
        System.out.println("Hello, i'm worker!");
    };

    /**
     *
     * Метод устанавливающий текущее место работы
     * @param name название компании
     */
    void setCompanyName(String name);

    /**
     *
     * Метод, устанавливающий зп
     * @param salary зп
     */
    void setSalary(int salary);

    /**
     *
     * Геттер, реализация которого необходима для метода
     * printStaff интерфейса IdealCompany
     * @return возвращает имя сотрудника
     */
    String getName();
}
