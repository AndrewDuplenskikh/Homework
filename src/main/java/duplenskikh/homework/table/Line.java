package duplenskikh.homework.table;

import java.util.ArrayList;

public class Line<T extends Comparable<T>> {
    private static int count = 0;
    private final int id;
    private final ArrayList<Comparable<?>> cells;

    public Line(int length) {
        this.cells = new ArrayList<>(length);
        id = count++;
    }

    public void addCell(T data) {
        cells.add(data);
    }

    public void setColumnValue(int columnIndex, Comparable<? extends Comparable<?>> data) {
        cells.set(columnIndex, data);
    }

    public Comparable<?> removeColumnValue(int columnIndex) {
        return cells.set(columnIndex, null);
    }

    public Comparable<?> getColumnValue(int columnIndex) {
        return cells.get(columnIndex);
    }

    public int getId() {
        return id;
    }
}
