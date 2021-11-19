package duplenskikh.homework.oop;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class CompanyTest {

    @Test
    void addEmployee() {
        AbstractWorker jack = new Person("Jack", 22);
        Company metaDevs = new Company("MetaDevs");
        assertThatNoException().isThrownBy(() -> {
            metaDevs.addEmployee(jack, 228);
        });
        assertThat(metaDevs.getEmployeeByIndex(0)).isEqualTo(jack);
    }

    @Test
    void addingExistentEmployeeThrowsIsPersonBelongsStaffException() {
        AbstractWorker jack = new Person("Jack", 22);
        Company metaDevs = new Company("MetaDevs");
        assertThatNoException().isThrownBy(() -> {
            metaDevs.addEmployee(jack, 228);
        });
        Throwable thrown = catchThrowable(() -> {
            metaDevs.addEmployee(jack, 228);
        });
        assertThat(thrown).isInstanceOf(IsPersonBelongsStaffException.class)
                .hasMessageContaining("This person is already in staff!");
    }

    @Test
    void gettingEmployeeByWrongIndexThrowsArrayIndexOutOfBoundsException() {
        Company metaDevs = new Company("MetaDevs");
        Throwable thrown = catchThrowable(() -> {
            metaDevs.getEmployeeByIndex(0);
        });
        assertThat(thrown).isInstanceOf(ArrayIndexOutOfBoundsException.class);
    }

    @Test
    void removeEmployee() {
        AbstractWorker jack = new Person("Jack", 22);
        Company metaDevs = new Company("MetaDevs");
        assertThatNoException().isThrownBy(() -> {
            metaDevs.addEmployee(jack, 228);
            metaDevs.removeEmployee(jack);
        });
        Throwable thrown = catchThrowable(() -> {
            metaDevs.getEmployeeByIndex(0);
        });
        assertThat(thrown).isInstanceOf(ArrayIndexOutOfBoundsException.class);
    }

    @Test
    void removingInexistentEmployeeThrowsIsPersonBelongsStaffException() {
        AbstractWorker jack = new Person("Jack", 22);
        Company metaDevs = new Company("MetaDevs");
        assertThatNoException().isThrownBy(() -> {
            metaDevs.addEmployee(jack, 228);
            metaDevs.removeEmployee(jack);
        });
        Throwable thrown = catchThrowable(() -> {
            metaDevs.removeEmployee(jack);
        });
        assertThat(thrown).isInstanceOf(IsPersonBelongsStaffException.class)
            .hasMessage("This person is out of staff!");
    }
}