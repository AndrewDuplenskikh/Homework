package duplenskikh.homework.exceptions;

public class WrongPasswordException extends Exception {
    public WrongPasswordException () {}

    public WrongPasswordException (String errorMessage) {
        super(errorMessage);
    }
}