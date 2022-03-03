package duplenskikh.homework.custom_stack;

public class CapacityException extends RuntimeException {
    public CapacityException() {
    }

    public CapacityException(String message) {
        super(message);
    }
}
