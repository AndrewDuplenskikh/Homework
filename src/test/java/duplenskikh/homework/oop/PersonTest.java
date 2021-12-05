package duplenskikh.homework.oop;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class PersonTest {

    /**
     * Class to remove
     * Валидация используется в методе "addEmployee" класса "Company"
     * и данный exception должен тестироваться именно там согласно общей практике.
     * Был создан тест "shouldThrowSalaryValidationExceptionWhileAddEmployee" в
     * "CompanyTest".
     */
    @Test
    void salaryValidationThrowsSalaryValidateException() {
        Workable jack = new Person("Jack", 228);
        assertThatExceptionOfType(SalaryValidateException.class).isThrownBy(() -> {
            jack.salaryValidate(22);
        });
    }

    @Test
    void salaryValidate() {
        Workable jack = new Person("Jack", 228);
        assertThatNoException().isThrownBy(() -> {
            jack.salaryValidate(300);
        });
    }
}