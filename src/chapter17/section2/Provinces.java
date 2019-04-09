package chapter17.section2;

import java.util.*;

public class Provinces {
    public static final String[][] DATA = {
            {"SHANDONG", "jinan"},
            {"BEIJING", "beijing"},
            {"HENAN", "zhengzhou"},
            {"HEBEI", "shijiazhuang"},
            {"JIANGSU", "nanjing"}
    };
    private static class ProvinceMap extends AbstractMap<String, String>{
        private static class Entry implements Map.Entry<String, String>{
            private int index;
            public Entry(int index){
                this.index = index;
            }
            @Override
            public String getKey() {
                return DATA[index][0];
            }

            @Override
            public String getValue() {
                return  DATA[index][1];
            }

            @Override
            public String setValue(String value) {
                throw new UnsupportedOperationException();
            }

            @Override
            public boolean equals(Object obj) {
                return DATA[index][0].equals(obj);
            }

            @Override
            public int hashCode() {
                return DATA[index][0].hashCode();
            }
        }

        static class EntrySet extends AbstractSet<Map.Entry<String, String>>{
            private int size;
            public EntrySet(){
                size = DATA.length;
            }
            public EntrySet(int size){
                this.size = size;
            }
            @Override
            public Iterator<Map.Entry<String, String>> iterator() {
                Entry entry = new Entry(-1);
                return new Iterator<Map.Entry<String, String>>() {
                    @Override
                    public boolean hasNext() {
                        return entry.index < size - 1;
                    }

                    @Override
                    public Map.Entry<String, String> next() {
                        entry.index++;
                        return entry;
                    }
                };
            }

            @Override
            public int size() {
                return size;
            }
        }

        @Override
        public Set<Map.Entry<String, String>> entrySet() {
            return new EntrySet();
        }
    }
    static Map<String, String> select(final int size){
        return new ProvinceMap(){
            @Override
            public Set<Map.Entry<String, String>> entrySet() {
                return new EntrySet(size);
            }
        };
    }
    public static Map<String, String> province(){
        return new ProvinceMap();
    }
    public static Map<String, String> province(int size){
        return select(size);
    }
    public static List<String> provincialCapital(){
        return new ArrayList<>(province().values());
    }
    public static List<String> provincialCapital(int size){
        return new ArrayList<>(province(size).values());
    }
}
