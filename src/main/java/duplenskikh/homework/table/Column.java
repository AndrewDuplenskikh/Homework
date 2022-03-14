package duplenskikh.homework.table;

public class Column {
    private final String title;
    private final Class<? extends Comparable<?>> className;

    public Column(String title, Class<? extends Comparable<?>> className) {
        this.title = title;
        this.className = className;
    }

    public Class<? extends Comparable<?>> getDataClass() {
        return className;
    }

    public String getTitle() {
        return title;
    }
}
