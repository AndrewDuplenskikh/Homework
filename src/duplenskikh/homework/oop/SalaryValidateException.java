package duplenskikh.homework.oop;

public class SalaryValidateException extends Exception {
    public SalaryValidateException() {

    }

    public SalaryValidateException(String errorMessage) {
        super(errorMessage);
    }
}
