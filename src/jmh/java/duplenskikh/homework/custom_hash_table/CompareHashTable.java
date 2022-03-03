package duplenskikh.homework.custom_hash_table;

import duplenskikh.homework.custom_linked_list.CustomLinkedList;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 10, time = 1)
@Measurement(iterations = 50, time = 10, timeUnit = TimeUnit.MILLISECONDS)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class CompareHashTable {

    @Benchmark
    public void add1000() {
        filledHashTable(1000);
    }

    @Benchmark
    public void add10000() {
        filledHashTable(10000);
    }

    @Benchmark
    public void add100000() {
        filledHashTable(100000);
    }

    @Benchmark
    public void addAndRemove1000() {
        filledHashTable(1000);
    }

    @Benchmark
    public void addAndRemove10000() {
        filledHashTable(10000);
    }

    @Benchmark
    public void addAndRemove100000() {
        filledHashTable(100000);
    }

    private CustomHashTable<String> filledHashTable(int count) {
        final CustomHashTable<String> hashTable = new CustomHashTable<>(count);
        for (int i = 0; i < count; i++) {
            hashTable.add(String.format("element %d", i));
        }
        return hashTable;
    }

    private void addAndRemoveElements(int count) {
        final CustomHashTable<String> hashTable = filledHashTable(count);
        for (int i = 0; i < count; i++) {
            hashTable.remove(String.format("element %d", i));
        }
    }
}
