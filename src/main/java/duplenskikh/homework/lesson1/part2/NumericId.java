package duplenskikh.homework.lesson1.part2;

public class NumericId implements Id {
    private final Integer value;

    public NumericId(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
