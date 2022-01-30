package duplenskikh.homework.custom_queue;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 10, time = 1)
@Measurement(iterations = 50, time = 10, timeUnit = TimeUnit.NANOSECONDS)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class CompareCustomQueue {
    @Benchmark
    public void offerElement1000() {
        CustomQueue<Integer> queue = new CustomQueue<>(1000);
        for (int i = 0; i < 999; i++) {
            queue.offer(i);
        }
    }

    @Benchmark
    public void offerElement10000() {
        CustomQueue<Integer> queue = new CustomQueue<>(10000);
        for (int i = 0; i < 9999; i++) {
            queue.offer(i);
        }
    }

    @Benchmark
    public void offerElement100000() {
        CustomQueue<Integer> queue = new CustomQueue<>(100000);
        for (int i = 0; i < 99999; i++) {
            queue.offer(i);
        }
    }

    @Benchmark
    public void offerAndRemoveElement1000() {
        CustomQueue<Integer> queue = new CustomQueue<>(1000);
        for (int i = 0; i < 999; i++) {
            queue.offer(i);
        }
        for (int i = 0; i < 999; i++) {
            queue.remove();
        }
    }

    @Benchmark
    public void offerAndRemoveElement10000() {
        CustomQueue<Integer> queue = new CustomQueue<>(10000);
        for (int i = 0; i < 9999; i++) {
            queue.offer(i);
        }
        for (int i = 0; i < 9999; i++) {
            queue.remove();
        }
    }

    @Benchmark
    public void offerAndRemoveElement100000() {
        CustomQueue<Integer> queue = new CustomQueue<>(100000);
        for (int i = 0; i < 99999; i++) {
            queue.offer(i);
        }
        for (int i = 0; i < 99999; i++) {
            queue.remove();
        }
    }
}
