package duplenskikh.homework.oop;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class PersonTest {

    @Test
    void salaryValidationThrowsSalaryValidateException() {
        Worker jack = new Person("Jack", 228);
        assertThatExceptionOfType(SalaryValidateException.class).isThrownBy(() -> {
            jack.salaryValidate(22);
        });
    }

    @Test
    void salaryValidate() {
        Worker jack = new Person("Jack", 228);
        assertThatNoException().isThrownBy(() -> {
            jack.salaryValidate(300);
        });
    }
}