package chapter17.section9.exercises;

import java.util.*;

public class FullSimpleHashMap<K,V> extends AbstractMap<K,V> {
    private final int LENGTH = 957;
    private int size = 0;
    private Entry<K,V>[] buckets = new Entry[LENGTH];
    private static class Entry<K,V> implements Map.Entry<K,V>{
        private K key;
        private V value;
        private Entry<K,V> next;
        Entry(K key, V value, Entry<K,V> next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V temp = this.value;
            this.value = value;
            return temp;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj){
                return true;
            }
            if (obj instanceof Entry){
                Entry entry = (Entry) obj;
                return key.equals(entry.key) && value.equals(entry.value);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return key.hashCode() ^ value.hashCode();
        }
    }
    @Override
    public V put(K key, V value) {
        if (key == null){
            throw new NullPointerException();
        }
        int index = Math.abs(key.hashCode()) % LENGTH;
        Entry preEntry = null;
        Entry<K,V> current = new Entry<>(key, value, null);
        for(Entry<K,V> entry = buckets[index]; entry != null; entry = entry.next){
            if (key.equals(entry.key)){
                return entry.setValue(value);
            } else {
                preEntry = entry;
            }

        }
        size++;
        if (preEntry == null){
            buckets[index] = current;
        } else {
            preEntry.next = current;
        }
        return null;
    }

    public int size(){
        return size;
    }

    @Override
    public V get(Object key) {
        if(key == null){
            throw new NullPointerException();
        }
        int index = key.hashCode() % LENGTH;
        for(Entry<K,V> entry = buckets[index]; entry != null; entry = entry.next){
            if (key.equals(entry.getKey())){
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public void clear() {
        //原话： Effectively erase everything by allocating
        // a new empty array of buckets:
        buckets = new Entry[LENGTH];
        size = 0;
    }

    @Override
    public V remove(Object key) {
        if(key == null){
            throw new NullPointerException();
        }
        int index = key.hashCode() % LENGTH;
        Entry<K,V> preEntry = null;
        for(Entry<K,V> entry = buckets[index]; entry != null; entry = entry.next){
            if (key.equals(entry.getKey())){
                V value = entry.value;
                if(preEntry == null){
                    buckets[index] = null;
                } else {
                    preEntry.next = entry.next;
                }
                size--;
                return value;
            }
            preEntry = entry;
        }
        return null;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return new AbstractSet<Map.Entry<K, V>>() {
            @Override
            public Iterator<Map.Entry<K, V>> iterator() {
                return new Ite();
            }

            @Override
            public int size() {
                return size;
            }
        };
    }

    private class Ite implements Iterator<Map.Entry<K, V>>{
        private int cursor = 0;
        private int index = -1;
        private Entry<K,V> current = null;
        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public Map.Entry<K, V> next() {
            if (hasNext()){
                cursor++;
                if(current == null || current.next == null){
                    for(int i = ++index; i < LENGTH; i++){
                        if (buckets[i] != null){
                            index = i;
                            current = buckets[i];
                            return current;
                        }
                    }
                } else{
                    current = current.next;
                    return current;
                }
            }
            throw new NoSuchElementException();
        }
        @Override
        public void remove() {
            if (current != null){
                FullSimpleHashMap.this.remove(current.key);
                size--;
                cursor--;
            }

        }
    }
}
