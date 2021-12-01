package duplenskikh.homework.lesson1.part2;

import duplenskikh.homework.oop.AbstractWorker;

import java.util.List;

public class User<T extends Id> {
    final private T id;

    public User(T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }

    public void compute(List<? extends AbstractWorker> list) {
        list.forEach(abstractWorker -> {
            System.out.println(abstractWorker.getName());
        });
    }

    public <V extends AbstractWorker> void change(V v) {

    }
}
