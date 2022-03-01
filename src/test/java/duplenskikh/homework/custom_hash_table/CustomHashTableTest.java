package duplenskikh.homework.custom_hash_table;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;

class CustomHashTableTest {
    private final CustomHashTable<String> hashTable = new CustomHashTable<>(23);

    @Test
    void addingElementsShouldFillHashTable() {
        assertThat(hashTable.isEmpty()).isTrue();
        fillHashTable();
        assertThat(hashTable.isEmpty()).isFalse();
    }

    @Test
    void addingDuplicateElementShouldBePossible() {
        String element = "element";
        hashTable.add(element);
        assertThatNoException().isThrownBy(() -> hashTable.add(element));
        hashTable.remove(element);
        hashTable.remove(element);
        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(() -> hashTable.find(element));
    }

    @Test
    void findingElementShouldReturnSpecifiedElement() {
        fillHashTable();
        String element = "element";
        hashTable.add(element);
        assertThat(hashTable.find(element)).isEqualTo(element);
    }

    @Test
    void findingNonexistentElementShouldThrowNoSuchElementException() {
        fillHashTable();
        String element = "nonexistent element";
        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(() -> hashTable.find(element));
    }

    @Test
    void removingElementShouldReturnSpecifiedElement() {
        fillHashTable();
        String element = "element";
        hashTable.add(element);
        assertThat(hashTable.remove(element)).isEqualTo(element);
        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(() -> hashTable.find(element));
    }

    @Test
    void removingNonexistentElementShouldThrowNoSuchElementException() {
        fillHashTable();
        String element = "nonexistent element";
        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(() -> hashTable.remove(element));
    }

    private void fillHashTable() {
        for (int i = 0; i < 10; i++) {
            hashTable.add(String.format("element %d", i));
        }
    }
}