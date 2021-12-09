package duplenskikh.homework.custom_array_list;

public class Application {
    public static void main(String[] args) {
        String[] def = new String[] {"a", "b", "c", "d"};
        CustomArrayList arr = new CustomArrayList<String>(def);
        System.out.println(arr.get(1));
        System.out.println(arr.get(0));
        System.out.println(arr.get(2));
        System.out.println(arr.size());
        System.out.println(arr.contains("a"));
        arr.remove(2);
        System.out.println(arr.size());
        System.out.println(arr.contains("c"));
        CustomArrayList sub = arr.subList(1, 3);
        System.out.println(sub.get(0));
        System.out.println(sub.get(1));
    }
}
