package duplenskikh.homework.oop;

public class Manager extends AbstractWorker {

    public Manager(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    @Override
    public void greeting() {
        System.out.println("Hello world, my name is " + this.getName() + ". I'm MANAGER");
    }
}
