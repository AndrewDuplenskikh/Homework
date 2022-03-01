package duplenskikh.homework.custom_linked_list;


import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 10, time = 1)
@Measurement(iterations = 50, time = 10, timeUnit = TimeUnit.MILLISECONDS)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class CompareLinkedList {
    @Benchmark
    public void offerFirstElement1000() {
        CustomLinkedList<String> linkedList = new CustomLinkedList<>();
        fillFromFront(linkedList, 1000);
    }

    @Benchmark
    public void offerFirstElement10000() {
        CustomLinkedList<String> linkedList = new CustomLinkedList<>();
        fillFromFront(linkedList, 10000);
    }

    @Benchmark
    public void offerFirstElement100000() {
        CustomLinkedList<String> linkedList = new CustomLinkedList<>();
        fillFromFront(linkedList, 100000);
    }

    @Benchmark
    public void offerLastElement1000() {
        CustomLinkedList<String> linkedList = new CustomLinkedList<>();
        fillFromBack(linkedList, 1000);
    }

    @Benchmark
    public void offerLastElement10000() {
        CustomLinkedList<String> linkedList = new CustomLinkedList<>();
        fillFromBack(linkedList, 10000);
    }

    @Benchmark
    public void offerLastElement100000() {
        CustomLinkedList<String> linkedList = new CustomLinkedList<>();
        fillFromBack(linkedList, 100000);
    }

    @Benchmark
    public void offerAndRemoveFirstElement1000() {
        CustomLinkedList<String> linkedList = new CustomLinkedList<>();
        fillFromFront(linkedList, 1000);
        removeAllElementsFromFront(linkedList);
    }

    @Benchmark
    public void offerAndRemoveFirstElement10000() {
        CustomLinkedList<String> linkedList = new CustomLinkedList<>();
        fillFromFront(linkedList, 10000);
        removeAllElementsFromFront(linkedList);
    }

    @Benchmark
    public void offerAndRemoveFirstElement100000() {
        CustomLinkedList<String> linkedList = new CustomLinkedList<>();
        fillFromFront(linkedList, 100000);
        removeAllElementsFromFront(linkedList);
    }

    @Benchmark
    public void offerAndRemoveLastElement1000() {
        CustomLinkedList<String> linkedList = new CustomLinkedList<>();
        fillFromBack(linkedList, 1000);
        removeAllElementsFromBack(linkedList);
    }

    @Benchmark
    public void offerAndRemoveLastElement10000() {
        CustomLinkedList<String> linkedList = new CustomLinkedList<>();
        fillFromBack(linkedList, 10000);
        removeAllElementsFromBack(linkedList);
    }

    @Benchmark
    public void offerAndRemoveLastElement100000() {
        CustomLinkedList<String> linkedList = new CustomLinkedList<>();
        fillFromBack(linkedList, 100000);
        removeAllElementsFromBack(linkedList);
    }

    private void fillFromFront(CustomLinkedList<String> linkedList, int count) {
        for (int i = 0; i < count; i++) {
            linkedList.addFirst(String.format("element %d", i));
        }
    }

    private void fillFromBack(CustomLinkedList<String> linkedList, int count) {
        for (int i = 0; i < count; i++) {
            linkedList.addLast(String.format("element %d", i));
        }
    }

    private void removeAllElementsFromFront(CustomLinkedList<String> linkedList) {
        while (!linkedList.isEmpty()) {
            linkedList.removeFirst();
        }
    }

    private void removeAllElementsFromBack(CustomLinkedList<String> linkedList) {
        while (!linkedList.isEmpty()) {
            linkedList.removeLast();
        }
    }
}
