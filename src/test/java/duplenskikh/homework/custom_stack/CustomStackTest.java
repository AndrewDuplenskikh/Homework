package duplenskikh.homework.custom_stack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CustomStackTest {
    private final CustomStack<String> stack = new CustomStack(10);

    @Test
    void emptyStackSizeShouldBeZero() {
        assertThat(stack.size()).isEqualTo(0);
    }

    @Test
    void addingElementShouldProvideIncrementingSize() {
        stack.push("element");
        assertThat(stack.size()).isEqualTo(1);
    }

    @Test
    void removingElementShouldProvideDecrementingSize() {
        stack.push("element");
        stack.pop();
        assertThat(stack.size()).isEqualTo(0);
    }

    @Test
    void addingExtraElementShouldThrowCapacityException() {
        for (int i = 0; i < 10; i++) {
            stack.push(String.format("element %d", i));
        }
        assertThatExceptionOfType(CapacityException.class).isThrownBy(() -> stack.push("extra"));
    }

    @Test
    void stackShouldContainSpecifiedElement() {
        String element = "element";
        stack.push(element);
        assertThat(stack.peek()).isEqualTo(element);
    }

    @Test
    void peekingEmptyStackShouldThrowCapacityException() {
        assertThatExceptionOfType(CapacityException.class).isThrownBy(() -> stack.peek());
    }

    @Test
    void removingFromEmptyStackShouldThrowCapacityException() {
        assertThatExceptionOfType(CapacityException.class).isThrownBy(() -> stack.pop());
    }
}