package duplenskikh.homework.oop;

public interface Workable {

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
}
