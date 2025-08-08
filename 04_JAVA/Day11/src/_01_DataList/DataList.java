package _01_DataList;

public class DataList {
    private Object[] data;
    private int size;
    private int defaultSize = 10;

    public DataList() {
        data = new Object[defaultSize];
    }

    public DataList(int size) {
        data = new Object[size];
    }

    public void add(Object value) {
        data[size++] = value;
    }

    public Object get(int index) {
        return data[index];
    }

    public int size() {
        return size;
    }
}
