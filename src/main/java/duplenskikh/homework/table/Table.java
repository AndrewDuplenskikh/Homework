package duplenskikh.homework.table;

import java.util.ArrayList;

public class Table<T extends Comparable<T>> {
    private final ArrayList<Column> header;
    private final ArrayList<Line<? extends Comparable<?>>> lines;

    public Table(int width, int height) {
        header = new ArrayList<>(width);
        lines = new ArrayList<>(height);
        for (int i = 0; i < height; i++) {
            lines.add(new Line<>(width));
        }
    }

    public void addColumn(Column column) {
        header.add(column);
        lines.forEach(line -> line.addCell(null));
    }

    public void addLine() {
        lines.add(new Line<>(header.size()));
    }

    public void setCellValue(int columnIndex, int lineIndex, Comparable<? extends Comparable<?>> data) {
        if (!getColumnClass(columnIndex).equals(data.getClass())) {
            throw new IllegalArgumentException("Wrong argument type for this column!");
        }
        Line<? extends Comparable<?>> line = lines.get(lineIndex);
        line.setColumnValue(columnIndex, data);
    }

    public Comparable<?> getCellValue(int columnIndex, int lineIndex) {
        Line<? extends Comparable<?>> line = lines.get(lineIndex);
        return line.getColumnValue(columnIndex);
    }

    public Comparable<?> removeCellValue(int columnIndex, int lineIndex) {
        Line<? extends Comparable<?>> line = lines.get(lineIndex);
        return line.removeColumnValue(columnIndex);
    }

    public int getWidth() {
        return header.size();
    }

    public int getHeight() {
        return lines.size();
    }

    private Class<? extends Comparable<?>> getColumnClass(int index) {
        Column column = header.get(index);
        return column.getDataClass();
    }
}
