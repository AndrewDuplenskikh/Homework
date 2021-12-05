package duplenskikh.homework.oop;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class CompanyTest {

    @Test
    void addEmployee() {
        AbstractWorker jack = new Person("Jack", 22);
        Company metaDevs = new Company("MetaDevs");
        metaDevs.addEmployee(jack, 228);
        assertThat(metaDevs.employeeByName("Jack")).isEqualTo(jack);
    }

    @Test
    void addingExistentEmployeeThrowsIsPersonBelongsStaffException() {
        AbstractWorker jack = new Person("Jack", 22);
        Company metaDevs = new Company("MetaDevs");
        metaDevs.addEmployee(jack, 228);
        assertThatExceptionOfType(PersonBelongsStaffException.class).isThrownBy(() -> {
            metaDevs.addEmployee(jack, 228);
        });
    }

    @Test
    void gettingEmployeeByWrongIndexThrowsArrayIndexOutOfBoundsException() {
        Company metaDevs = new Company("MetaDevs");
        assertThatExceptionOfType(WorkerNotFoundException.class).isThrownBy(() -> {
            metaDevs.employeeByName("petya");
        });
    }

    @Test
    void removeEmployee() {
        AbstractWorker jack = new Person("Jack", 22);
        Company metaDevs = new Company("MetaDevs");
        metaDevs.addEmployee(jack, 228);
        metaDevs.removeEmployee(jack);
        assertThatExceptionOfType(WorkerNotFoundException.class).isThrownBy(() -> {
            metaDevs.employeeByName("Jack");
        });
    }

    @Test
    void removingInexistentEmployeeThrowsIsPersonBelongsStaffException() {
        AbstractWorker jack = new Person("Jack", 22);
        Company metaDevs = new Company("MetaDevs");
        metaDevs.addEmployee(jack, 228);
        metaDevs.removeEmployee(jack);
        assertThatExceptionOfType(WorkerNotFoundException.class).isThrownBy(() -> {
            metaDevs.removeEmployee(jack);
        });
    }
}