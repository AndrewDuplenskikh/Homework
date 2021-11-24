package duplenskikh.homework.oop;

import java.util.NoSuchElementException;

public class WorkerNotFoundException extends NoSuchElementException {
    public WorkerNotFoundException() {
    }

    public WorkerNotFoundException(String message) {
        super(message);
    }
}
