package chapter17.section2.exercises;

import java.util.*;

public class CountingDataMap extends AbstractMap<Integer,String> {
    private int size;
    public CountingDataMap(int size){
        this.size = size;
    }
    private static String[] CHARS = "A B C D E F G H I J K L M N O P Q R S T U String W X Y Z".split(" ");
    @Override
    public Set<Map.Entry<Integer, String>> entrySet() {
        return new EntrySet();
    }
    private static class Entry implements Map.Entry<Integer, String>{
        private int index;
        public Entry(int index){
            this.index = index;
        }
        @Override
        public Integer getKey() {
            return index;
        }

        @Override
        public String getValue() {
            return CHARS[index % CHARS.length] + String.valueOf(index/CHARS.length);
        }

        @Override
        public String setValue(String value) {
            throw new UnsupportedOperationException();
        }
    }
    private class EntrySet extends AbstractSet<Map.Entry<Integer, String>>{
        public EntrySet(){
        }
        @Override
        public Iterator<Map.Entry<Integer, String>> iterator() {
            return new Ite();
        }

        @Override
        public int size() {
            return size;
        }
    }
    private class Ite implements Iterator<Map.Entry<Integer, String>>{
        private Entry entry = new Entry(-1);

        @Override
        public boolean hasNext() {
            return entry.index < size - 1;
        }

        @Override
        public Map.Entry<Integer, String> next() {
            entry.index ++;
            return entry;
        }
    }

    public static void main(String[] args) {
        System.out.println(new CountingDataMap(60));
    }
}
