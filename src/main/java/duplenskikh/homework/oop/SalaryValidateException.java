package duplenskikh.homework.oop;

public class SalaryValidateException extends IllegalArgumentException {
    public SalaryValidateException() {

    }

    public SalaryValidateException(String errorMessage) {
        super(errorMessage);
    }
}
