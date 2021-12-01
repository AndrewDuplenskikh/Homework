package duplenskikh.homework.lesson1.part2;

public class Application {
    public static void main(String[] args) {
        User<SymbolicId> user1 = new User<>(new SymbolicId("first"));
        User<NumericId> user2 = new User<>(new NumericId(1));
        System.out.println(user1.getId() + user1.getId().getClass().toString());
        System.out.println(user2.getId() + user2.getId().getClass().toGenericString());
    }
}
