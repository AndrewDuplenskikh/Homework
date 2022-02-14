package duplenskikh.homework.custom_binary_tree;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 10, time = 1)
@Measurement(iterations = 50, time = 10, timeUnit = TimeUnit.MILLISECONDS)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class CompareBinaryTree {

    private void fillBinaryTree(int count, CustomBinaryTree<String> binaryTree) {
        for (int i = 0; i < count; i++) {
            if (i % 2 == 0) {
                binaryTree.addElement(i - count / 2, String.format("element %d", i));
                continue;
            }
            binaryTree.addElement(i, String.format("element %d", i));
        }
    }

    private void removeAllElementsOfBinaryTree(int count, CustomBinaryTree<String> binaryTree) {
        for (int i = 0; i < count - 1; i++) {
            if (i % 2 == 0) {
                binaryTree.removeElement(i - count / 2);
                continue;
            }
            binaryTree.removeElement(i);
        }
    }

    @Benchmark
    public void addElement100() {
        CustomBinaryTree<String> binaryTree = new CustomBinaryTree<>();
        fillBinaryTree(100, binaryTree);
    }

    @Benchmark
    public void addElement1000() {
        CustomBinaryTree<String> binaryTree = new CustomBinaryTree<>();
        fillBinaryTree(1000, binaryTree);
    }

    @Benchmark
    public void addElement10000() {
        CustomBinaryTree<String> binaryTree = new CustomBinaryTree<>();
        fillBinaryTree(10000, binaryTree);
    }

    @Benchmark
    public void addAndRemoveElement100() {
        CustomBinaryTree<String> binaryTree = new CustomBinaryTree<>();
        fillBinaryTree(100, binaryTree);
        removeAllElementsOfBinaryTree(100, binaryTree);
    }

    @Benchmark
    public void addAndRemoveElement1000() {
        CustomBinaryTree<String> binaryTree = new CustomBinaryTree<>();
        fillBinaryTree(1000, binaryTree);
        removeAllElementsOfBinaryTree(1000, binaryTree);
    }

    @Benchmark
    public void addAndRemoveElement10000() {
        CustomBinaryTree<String> binaryTree = new CustomBinaryTree<>();
        fillBinaryTree(10000, binaryTree);
        removeAllElementsOfBinaryTree(10000, binaryTree);
    }
}
