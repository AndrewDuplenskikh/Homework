package duplenskikh.homework.oop;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class PersonTest {

    @Test
    void salaryValidationThrowsSalaryValidateException() {
        Worker Jack = new Person("Jack", 228);
        Throwable thrown = catchThrowable(() -> {
            Jack.salaryValidate(22);
        });
        assertThat(thrown).isInstanceOf(SalaryValidateException.class)
                .hasMessageContaining("Age is greater than salary!");
    }

}