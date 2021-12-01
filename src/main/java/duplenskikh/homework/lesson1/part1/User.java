package duplenskikh.homework.lesson1.part1;

public class User<T> {
    final private T id;

    public User(T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }
}
