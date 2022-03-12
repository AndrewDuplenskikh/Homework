package duplenskikh.homework.table;

import java.util.ArrayList;

public class Line<T extends Comparable<T>> {
    static int count = 0;
    int id;
    public ArrayList<Comparable<?>> cells;

    public Line(int length) {
        this.cells = new ArrayList<>(length);
        id = count++;
    }

    public void addCell(T data) {
        cells.add(data);
    }

    public void setCellValue(int columnNumber, Comparable<? extends Comparable<?>> data) {
        cells.set(columnNumber, data);
    }
}
