package duplenskikh.homework.oop;

public class PersonBelongsStaffException extends IllegalArgumentException {
    public PersonBelongsStaffException() {

    }

    public PersonBelongsStaffException(String errorMessage) {
        super(errorMessage);
    }
}
