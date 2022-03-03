package duplenskikh.homework.custom_queue;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;

class CustomQueueTest {
    private final CustomQueue<String> queue = new CustomQueue(10);

    @Test
    void emptyQueueSizeShouldBeZero() {
        assertThat(queue.size()).isEqualTo(0);
    }

    @Test
    void addingElementShouldProvideIncrementingSize() {
        queue.add("element");
        assertThat(queue.size()).isEqualTo(1);
    }

    @Test
    void removingElementShouldProvideDecrementingSize() {
        queue.add("element");
        queue.remove();
        assertThat(queue.size()).isEqualTo(0);
    }

    @Test
    void addingExtraElementShouldThrowIllegalStateException() {
        for (int i = 0; i < 10; i++) {
            queue.add(String.format("element %d", i));
        }
        assertThatExceptionOfType(IllegalStateException.class).isThrownBy(() -> queue.add("extra"));
    }

    @Test
    void queueShouldContainSpecifiedElement() {
        String element = "element";
        queue.add(element);
        assertThat(queue.peek()).isEqualTo(element);
    }

    @Test
    void peekingEmptyQueueShouldThrowNoSuchElementException() {
        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(() -> queue.peek());
    }

    @Test
    void removingFromEmptyQueueShouldThrowCapacityException() {
        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(() -> queue.remove());
    }
}