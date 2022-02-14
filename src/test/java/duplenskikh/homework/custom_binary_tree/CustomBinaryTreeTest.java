package duplenskikh.homework.custom_binary_tree;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;

class CustomBinaryTreeTest {
    private CustomBinaryTree<String> binaryTree = new CustomBinaryTree<>();

    @Test
    void emptyBinaryTreeShouldBeEmpty() {
        assertThat(binaryTree.isEmpty()).isEqualTo(true);
    }

    @Test
    void addingElementShouldFillBinaryTree() {
        binaryTree.addElement(2, "element");
        assertThat(binaryTree.isEmpty()).isEqualTo(false);
    }

    @Test
    void addingExistantElementShouldThrowIllegalArgumentException() {
        binaryTree.addElement(2, "element");
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            binaryTree.addElement(2, "another");
        });
    }

    @Test
    void searchShouldReturnSpecifiedElement() {
        String element = "element";
        binaryTree.addElement(2, element);
        binaryTree.addElement(3, "Hello");
        binaryTree.addElement(5, "world");
        binaryTree.addElement(1, "!");
        assertThat(binaryTree.findElement(2)).isEqualTo(element);
    }

    @Test
    void searchWrongElementShouldThrowNoSuchElementException() {
        binaryTree.addElement(2, "element");
        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(() -> {
            binaryTree.findElement(10);
        });
    }

    @Test
    void removingShouldReturnSpecifiedElement() {
        String element = "element";
        binaryTree.addElement(3, "Hello");
        binaryTree.addElement(5, "world");
        binaryTree.addElement(2, element);
        binaryTree.addElement(1, "!");
        assertThat(binaryTree.removeElement(2)).isEqualTo(element);
    }

    @Test
    void removingWrongElementShouldThrowNoSuchElementException() {
        binaryTree.addElement(2, "element");
        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(() -> {
            binaryTree.removeElement(10);
        });
    }
}