package chapter17.section9.exercises;

import common.generator.MapGenerator;

import java.util.*;

public class SlowerMap<K,V> extends AbstractMap<K,V> {
    private List<K> keys = new ArrayList<>();
    private List<V> values = new ArrayList<>();

    @Override
    public V get(Object key) {
        if (key == null){
            return null;
        }
        if(!keys.contains(key)){
            return null;
        }
        return values.get(keys.indexOf(key));
    }

    @Override
    public V put(K key, V value) {
        if (key == null) {
            throw new IndexOutOfBoundsException();
        }
        V result = get(key);
        if(result != null){
            values.set(keys.indexOf(key), value);
        } else {
            keys.add(key);
            values.add(value);
        }
        return result;
    }
    private Set<Entry<K,V>> entrySet = new EntrySet();
    @Override
    public Set<Entry<K, V>> entrySet() {
        return entrySet;
    }

    @Override
    public void clear() {
        keys.clear();
        values.clear();
    }

    @Override
    public V remove(Object key) {
        int index = keys.indexOf(key);
        if (index == -1){
            return null;
        }
        keys.remove(index);
        return values.remove(index);
    }
    public V remove(int index) {
        checkIndex(index);
        keys.remove(index);
        return values.remove(index);
    }

    // 享元
    private class EntrySet extends AbstractSet<Entry<K,V>>{

        @Override
        public Iterator<Entry<K, V>> iterator() {
            return new Ite();
        }

        @Override
        public int size() {
            return keys.size();
        }
    }
    private class Ite implements Iterator<Entry<K, V>>{
        int index = 0;
        int lastReturn = -1;
        @Override
        public boolean hasNext() {
            return index < keys.size();
        }

        @Override
        public Entry<K, V> next() {
            lastReturn = index;
            index++;
            return new EntryMap(lastReturn);
        }

        @Override
        public void remove() {
            checkIndex(lastReturn);
            SlowerMap.this.remove(lastReturn);
            index = lastReturn;
            lastReturn = -1;
        }
    }
    private void checkIndex(int index){
        if (index > size()-1)
        throw new IndexOutOfBoundsException(String.valueOf(index));
    }
    private class EntryMap implements Entry<K,V>{
        private final int index;
        EntryMap(int index){
            checkIndex(index);
            if (index < 0){
                this.index = 0;
            } else {
                this.index = index;
            }
        }
        @Override
        public K getKey() {
            return keys.get(index);
        }

        @Override
        public V getValue() {
            return values.get(index);
        }

        @Override
        public V setValue(V value) {
            throw new UnsupportedOperationException();
        }

        @Override
        public String toString() {
            return String.valueOf(getKey()) + "=" + getValue();
        }

        @Override
        public boolean equals(Object obj) {
            return this == obj || obj instanceof SlowerMap.EntryMap && index == ((EntryMap) obj).index;
        }

        @Override
        public int hashCode() {
            return getKey().hashCode() ^ (getValue() == null? 0: getValue().hashCode());
        }
    }

    public static void main(String[] args) {
        SlowerMap<Integer, String> map = new SlowerMap<>();
        map.putAll(MapGenerator.mapDefault(10));
        SlowerMap.EntryMap  entryMap1 = map.new EntryMap(0);
        SlowerMap.EntryMap  entryMap2 = map.new EntryMap(0);
        SlowerMap.EntryMap  entryMap3 = map.new EntryMap(0);
        System.out.println(entryMap1);
        System.out.println(entryMap2);
        System.out.println(entryMap3);
        System.out.println(entryMap1.equals(null));
        System.out.println(entryMap1.equals(entryMap1));
        System.out.println(entryMap1.equals(entryMap2));
        System.out.println(entryMap2.equals(entryMap1));
        System.out.println(entryMap2.equals(entryMap3));
        System.out.println(entryMap1.equals(entryMap3));
    }
}
