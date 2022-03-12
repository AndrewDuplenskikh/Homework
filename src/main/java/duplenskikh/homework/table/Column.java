package duplenskikh.homework.table;

public class Column<T extends Comparable<T>> {
    public String title;
    public T data;

    public Column(String title) {
        this.title = title;
    }

    public Column(String title, T data) {
        this.title = title;
        this.data = data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Class<? extends Comparable> getDataClass() {
        return data.getClass();
    }
}
