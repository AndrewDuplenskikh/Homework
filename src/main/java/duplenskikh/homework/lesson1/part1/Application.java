package duplenskikh.homework.lesson1.part1;

public class Application {
    public static void main(String[] args) {
        User<Integer> user1 = new User<>(1);
        User<String> user2 = new User<>("some");
        System.out.println(user1.getId() + user1.getId().getClass().toString());
        System.out.println(user2.getId() + user2.getId().getClass().toGenericString());
    }
}
