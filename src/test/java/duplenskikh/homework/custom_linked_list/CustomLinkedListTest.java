package duplenskikh.homework.custom_linked_list;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;

class CustomLinkedListTest {
    private final CustomLinkedList<String> linkedList = new CustomLinkedList<>(new String[]{"first", "second", "third"});

    @Test
    void filledLinkedListShouldNotBeEmpty() {
        linkedList.addFirst("element");
        assertThat(linkedList.isEmpty()).isEqualTo(false);
    }

    @Test
    void removingFirstShouldReturnSpecifiedElement() {
        assertThat(linkedList.removeFirst()).isEqualTo("first");
    }

    @Test
    void removingLastShouldReturnSpecifiedElement() {
        assertThat(linkedList.removeLast()).isEqualTo("third");
    }

    @Test
    void addingForwardShouldPushElementInFrontOfList() {
        linkedList.addFirst("element");
        assertThat(linkedList.removeFirst()).isEqualTo("element");
    }

    @Test
    void addingBackwardShouldPushElementInBackOfList() {
        linkedList.addLast("element");
        assertThat(linkedList.removeLast()).isEqualTo("element");
    }

    @Test
    void removingByKeyShouldReturnSpecifiedElement() {
        assertThat(linkedList.removeKey("second")).isEqualTo("second");
    }

    @Test
    void removingWrongElementShouldThrowNoSuchElementException() {
        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(() -> linkedList.removeKey("fourth"));
    }

    @Test
    void addingAfterSpecifiedElementShouldPushElementInList() {
        linkedList.addAfter("second", "element");
        linkedList.removeLast();
        assertThat(linkedList.removeLast()).isEqualTo("element");
    }

    @Test
    void addingAfterWrongElementShouldThrowNoSuchElementException() {
        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(() -> linkedList.addAfter("fourth", "element"));
    }

    @Test
    void findingElementShouldReturnSpecifiedElement() {
        assertThat(linkedList.find("first")).isEqualTo("first");
    }

    @Test
    void findingNonexistentElementShouldThrowNoSuchElementException() {
        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(() -> linkedList.find("element"));
    }
}