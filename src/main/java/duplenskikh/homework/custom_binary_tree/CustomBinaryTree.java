package duplenskikh.homework.custom_binary_tree;

import java.util.NoSuchElementException;

public class CustomBinaryTree<E> implements BinaryTree<E> {
    private CustomNode<E> root;

    private class CustomNode<E> {
        public E data;
        public int key;
        public CustomNode<E> leftChild;
        public CustomNode<E> rightChild;

        public CustomNode(int key, E data) {
            this.data = data;
            this.key = key;
            leftChild = null;
            rightChild = null;
        }
    }

    public CustomBinaryTree() {
    }

    public CustomBinaryTree(int key, E e) {
        CustomNode<E> root = new CustomNode<E>(key, e);
        this.root = root;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void addElement(int key, E e) {
        CustomNode<E> node = new CustomNode<E>(key, e);
        if (isEmpty()) {
            root = node;
            return;
        }
        CustomNode<E> current = root;
        CustomNode<E> parent;
        while (true) {
            parent = current;
            if (current.key == key) {
                throw new IllegalArgumentException("Same element is already in tree");
            }
            if (key > current.key) {
                current = parent.rightChild;
                if (current == null) {
                    parent.rightChild = node;
                    return;
                }
            } else {
                current = parent.leftChild;
                if (current == null) {
                    parent.leftChild = node;
                    return;
                }
            }
        }
    }

    @Override
    public E findElement(int key) {
        CustomNode<E> current = root;
        while (current.key != key) {
            if (key > current.key) {
                current = current.rightChild;
            } else {
                current = current.leftChild;
            }
            if (current == null) {
                throw new NoSuchElementException("Element not found");
            }
        }
        return current.data;
    }

    @Override
    public E removeElement(int key) {
        CustomNode<E> current = root;
        CustomNode<E> parent = root;
        boolean isLeftChild = true;
        while (current.key != key) {
            parent = current;
            if (key > current.key) {
                current = parent.rightChild;
                isLeftChild = false;
            } else {
                current = parent.leftChild;
                isLeftChild = true;
            }
            if (current == null) {
                throw new NoSuchElementException("Element not found");
            }
        }
        if (current.leftChild == null && current.rightChild == null) {
            return swapNode(null, parent, current, isLeftChild);
        }
        if (current.rightChild == null) {
            return swapNode(current.leftChild, parent, current, isLeftChild);
        }
        if (current.leftChild == null) {
            return swapNode(current.rightChild, parent, current, isLeftChild);
        }
        CustomNode<E> successor = successor(current);
        successor.leftChild = current.leftChild;
        return swapNode(successor, parent, current, isLeftChild);
    }

    private CustomNode<E> successor(CustomNode<E> node) {
        CustomNode<E> parent = node;
        CustomNode<E> successor = node;
        CustomNode<E> current = node.rightChild;
        while (current != null) {
            parent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (!successor.equals(node.rightChild)) {
            parent.leftChild = successor.rightChild;
            successor.rightChild = node.rightChild;
        }
        return successor;
    }

    private E swapNode(CustomNode<E> toSwap, CustomNode<E> parent, CustomNode<E> toRemove, boolean isLeftChild) {
        if (toRemove.equals(root)) {
            root = toSwap;
            return toRemove.data;
        }
        if (isLeftChild) {
            parent.leftChild = toSwap;
            return toRemove.data;
        } else {
            parent.rightChild = toSwap;
            return toRemove.data;
        }
    }
}
