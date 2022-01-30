package duplenskikh.homework.custom_stack;

import org.openjdk.jmh.annotations.*;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 10, time = 1)
@Measurement(iterations = 50, time = 10, timeUnit = TimeUnit.NANOSECONDS)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class CompareCustomStack {
    @Benchmark
    public void pushElement1000() {
        CustomStack<Integer> stack = new CustomStack<>(1000);
        for (int i = 0; i < 999; i++) {
            stack.push(i);
        }
    }

    @Benchmark
    public void pushElement10000() {
        CustomStack<Integer> stack = new CustomStack<>(10000);
        for (int i = 0; i < 9999; i++) {
            stack.push(i);
        }
    }

    @Benchmark
    public void pushElement100000() {
        CustomStack<Integer> stack = new CustomStack<>(100000);
        for (int i = 0; i < 99999; i++) {
            stack.push(i);
        }
    }

    @Benchmark
    public void pushAndPopElement1000() {
        CustomStack<Integer> stack = new CustomStack<>(1000);
        for (int i = 0; i < 999; i++) {
            stack.push(i);
        }
        for (int i = 0; i < 999; i++) {
            stack.pop();
        }
    }

    @Benchmark
    public void pushAndPopElement10000() {
        CustomStack<Integer> stack = new CustomStack<>(10000);
        for (int i = 0; i < 9999; i++) {
            stack.push(i);
        }
        for (int i = 0; i < 9999; i++) {
            stack.pop();
        }
    }

    @Benchmark
    public void pushAndPopElement100000() {
        CustomStack<Integer> stack = new CustomStack<>(100000);
        for (int i = 0; i < 99999; i++) {
            stack.push(i);
        }
        for (int i = 0; i < 99999; i++) {
            stack.pop();
        }
    }
}
