package duplenskikh.homework.table;

import java.util.ArrayList;

public class Table<T extends Comparable<T>> {
    private ArrayList<Column<? extends Comparable<?>>> header;
    private ArrayList<Line<? extends Comparable<?>>> lines;
    private int width;
    private int height;

    public Table(int width, int height) {
        this.width = width;
        this.height = height;
        header = new ArrayList<>(width);
        lines = new ArrayList<>(height);
        lines.forEach(line -> line = new Line<>(width));
    }

    public void addColumn(Column<? extends Comparable<?>> column) {
        lines.forEach(line -> line.addCell(null));
        width++;
    }

    public void addLine() {
        lines.add(new Line<>(width));
        height++;
    }

    public void setCellValue(int columnNumber, int lineNumber, Comparable<? extends Comparable<?>> data) {
        if (!getColumn(columnNumber).getDataClass().equals(data.getClass())) {
            throw new IllegalArgumentException("Wrong argument type for this column!");
        }
        lines.get(lineNumber).setCellValue(columnNumber, data);
    }

    private Column<? extends Comparable<?>> getColumn(int index) {
        return header.get(index);
    }
}
