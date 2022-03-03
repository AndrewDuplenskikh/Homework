package duplenskikh.homework.custom_array_list;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 10, time = 1)
@Measurement(iterations = 50, time = 10, timeUnit = TimeUnit.MILLISECONDS)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class CompareRemove {
    /**
     * Тест:
     * 1. В каждом тесте создаем 3 массива различной длины.
     * 2. Заполняем их.
     * 3. В первом тесте - работаем с первым массивом, удаляем последний элемент.
     * 4. Во втором - тоже самое со вторым массивом. В третьем - третий массив.
     * 5. Получаем результаты (время выполнения метода) и соотносим со сложностью (O(n)).
     */
    @Benchmark
    public void removeElement1000() {
        CustomArrayList<String> customArrayList1 = new CustomArrayList(1000);
        for (int i = 0; i < 999; i++) {
            customArrayList1.add(String.valueOf(i));
        }
        CustomArrayList<String> customArrayList2 = new CustomArrayList(100000);
        for (int i = 0; i < 99999; i++) {
            customArrayList2.add(String.valueOf(i));
        }
        CustomArrayList<String> customArrayList3 = new CustomArrayList(1000000);
        for (int i = 0; i < 999999; i++) {
            customArrayList3.add(String.valueOf(i));
        }
        customArrayList1.remove(String.valueOf(999));
    }

    @Benchmark
    public void removeElement100000() {
        CustomArrayList<String> customArrayList1 = new CustomArrayList(1000);
        for (int i = 0; i < 999; i++) {
            customArrayList1.add(String.valueOf(i));
        }
        CustomArrayList<String> customArrayList2 = new CustomArrayList(100000);
        for (int i = 0; i < 99999; i++) {
            customArrayList2.add(String.valueOf(i));
        }
        CustomArrayList<String> customArrayList3 = new CustomArrayList(1000000);
        for (int i = 0; i < 999999; i++) {
            customArrayList3.add(String.valueOf(i));
        }
        customArrayList2.remove(String.valueOf(99999));
    }

    @Benchmark
    public void removeElement1000000() {
        CustomArrayList<String> customArrayList1 = new CustomArrayList(1000);
        for (int i = 0; i < 999; i++) {
            customArrayList1.add(String.valueOf(i));
        }
        CustomArrayList<String> customArrayList2 = new CustomArrayList(100000);
        for (int i = 0; i < 99999; i++) {
            customArrayList2.add(String.valueOf(i));
        }
        CustomArrayList<String> customArrayList3 = new CustomArrayList(1000000);
        for (int i = 0; i < 999999; i++) {
            customArrayList3.add(String.valueOf(i));
        }
        customArrayList3.remove(String.valueOf(999999));
    }
}
