package duplenskikh.homework.lesson1.part3;

public class Application {
    public static void main(String[] args) {
        Callback callback = string -> {
            System.out.println(string);
        };

        Callback callback2 = new Callback() {
            @Override
            public void compute(String string) {
                System.out.println(string);
            }
        };

        FunctionCallback functionCallback = string -> string.toLowerCase();

        FunctionCallback functionCallback2 = new FunctionCallback() {
            @Override
            public String compute(String string) {
                return string.toLowerCase();
            }
        };

        Person jack = new Person("Jack");
        jack.handleName(functionCallback);
        System.out.println(jack.getName());
        jack.handleName(string -> string.toUpperCase());
        System.out.println(jack.getName());

        functionCallback.compute(jack.getName());

        callback.compute("message1");
        callback2.compute("message2");
        System.out.println(functionCallback.compute("MEssAGE3"));
        System.out.println(functionCallback2.compute("MEssAGE4"));
    }
}
