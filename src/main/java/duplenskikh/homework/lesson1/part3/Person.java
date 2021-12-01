package duplenskikh.homework.lesson1.part3;

public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void handleName(FunctionCallback functionCallback) {
        name = functionCallback.compute(name);
    }

    public String toLowerCase() {
        return name.toLowerCase();
    }
}
