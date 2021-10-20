package duplenskikh.homework.exceptions;

public class WrongLoginException extends Exception {
    public WrongLoginException () {}

    public WrongLoginException (String errorMessage) {
        super(errorMessage);
    }
}
