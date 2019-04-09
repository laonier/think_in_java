package chapter17.section2;

import java.util.AbstractList;

public class CountingIntegerList extends AbstractList<Integer> {
    private int size;
    public CountingIntegerList(int size){
        this.size = size < 0 ? 0 : size;
    }
    @Override
    public Integer get(int index) {
        return index;
    }

    @Override
    public int size() {
        return size;
    }
    public static CountingIntegerList Counting(int size){
        return new CountingIntegerList(size);
    }
    public static void main(String[] args) {
        System.out.println(CountingIntegerList.Counting(30));
    }
}
