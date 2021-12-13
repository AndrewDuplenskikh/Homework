package duplenskikh.homework.custom_array_list;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 10, time = 1)
@Measurement(iterations = 70, time = 1, timeUnit = TimeUnit.MICROSECONDS)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class CompareAdd {
    @Benchmark
    public void addElement20() {
        CustomArrayList customArrayList1 = new CustomArrayList<Integer>(21);
        for (int i = 1; i < 20; i++) {
            customArrayList1.add(i);
        }
        CustomArrayList customArrayList2 = new CustomArrayList<Integer>(41);
        for (int i = 1; i < 40; i++) {
            customArrayList2.add(i);
        }
        CustomArrayList customArrayList3 = new CustomArrayList<Integer>(61);
        for (int i = 1; i < 60; i++) {
            customArrayList3.add(i);
        }
        customArrayList1.add(21);
    }

    @Benchmark
    public void addElement40() {
        CustomArrayList customArrayList1 = new CustomArrayList<Integer>(21);
        for (int i = 1; i < 20; i++) {
            customArrayList1.add(i);
        }
        CustomArrayList customArrayList2 = new CustomArrayList<Integer>(41);
        for (int i = 1; i < 40; i++) {
            customArrayList2.add(i);
        }
        CustomArrayList customArrayList3 = new CustomArrayList<Integer>(61);
        for (int i = 1; i < 60; i++) {
            customArrayList3.add(i);
        }
        customArrayList2.add(41);
    }

    @Benchmark
    public void addElement60() {
        CustomArrayList customArrayList1 = new CustomArrayList<Integer>(21);
        for (int i = 1; i < 20; i++) {
            customArrayList1.add(i);
        }
        CustomArrayList customArrayList2 = new CustomArrayList<Integer>(41);
        for (int i = 1; i < 40; i++) {
            customArrayList2.add(i);
        }
        CustomArrayList customArrayList3 = new CustomArrayList<Integer>(61);
        for (int i = 1; i < 60; i++) {
            customArrayList3.add(i);
        }
        customArrayList3.add(61);
    }
}
