package duplenskikh.homework;

import duplenskikh.homework.table.Column;
import duplenskikh.homework.table.Table;

public class Main {
    public static void main(String[] args) {
        Table<? extends Comparable<?>> table = new Table<>(1, 5);
        table.addColumn(new Column("string", String.class));
        table.addColumn(new Column("int", Integer.class));
        table.addColumn(new Column("int2", Integer.class));


        table.setCellValue(0, 0, "str");
        table.setCellValue(0, 1, "s123tr");
        table.setCellValue(1, 0, 22);
        table.setCellValue(1, 1, 33);
    }
}
