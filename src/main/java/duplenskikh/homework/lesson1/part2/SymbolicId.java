package duplenskikh.homework.lesson1.part2;

public class SymbolicId implements Id{
    private final String value;

    public SymbolicId(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
