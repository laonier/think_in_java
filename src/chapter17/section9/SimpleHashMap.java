package chapter17.section9;

import java.util.*;

public class SimpleHashMap<K,V> extends AbstractMap<K,V> {
    private final int LENGTH = 957;
    private int size = 0;
    LinkedHashSet<Entry<K,V>>[] buckets = new LinkedHashSet[LENGTH];

    @Override
    public V put(K key, V value) {
        if (key == null){
            throw new NullPointerException();
        }
        int index = key.hashCode() % LENGTH;
        LinkedHashSet<Entry<K,V>> entries;
        V oldValue = null;
        if (buckets[index] == null){
            entries = new LinkedHashSet<>();
            entries.add(new EntryMap(key, value));
            buckets[index] = entries;
            size++;
        } else {
            entries = buckets[index];
            for(Entry<K,V> entry: entries){
                if (key.equals(entry.getKey())){
                    oldValue = entry.getValue();
                    entry.setValue(value);
                    break;
                }
            }
            if (oldValue == null){
                entries.add(new EntryMap(key, value));
                size++;
            }
        }
        return oldValue;
    }

    public int size(){
// Could rely on the inherited implementation, which
// returns entrySet().size(), but this is faster:
//        int sz = 0;
//        for(LinkedList<MapEntry<K,V>> bucket : buckets)
//            if(bucket != null)
//                sz += bucket.size();
//        最快的返回数量没有之一，缺点：在修改的数组的操作容易忘记修改size
        return size;
    }

    @Override
    public V get(Object key) {
        if(key == null){
            throw new NullPointerException();
        }
        int index = key.hashCode() % LENGTH;
        if (buckets[index] == null){
            return null;
        }
        for(Entry<K,V> entry: buckets[index]){
            if (key.equals(entry.getKey())){
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public void clear() {
//        for(int i = 0; i < buckets.length; i++){
//            buckets[i] = null;
//        }
        //原话： Effectively erase everything by allocating
        // a new empty array of buckets:
        buckets = new LinkedHashSet[LENGTH];
        size = 0;
    }

    @Override
    public V remove(Object key) {
        if(key == null){
            throw new NullPointerException();
        }
        int index = key.hashCode() % LENGTH;
        LinkedHashSet<Entry<K,V>> bucket = buckets[index];
        if (bucket == null){
            return null;
        }
        Iterator<Entry<K,V>> ite = bucket.iterator();
        while (ite.hasNext()){
            Entry<K,V> entry = ite.next();
            if(key.equals(entry.getKey())){
                V v = entry.getValue();
                ite.remove();
                size--;
                return v;
            }
        }
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return new AbstractSet<Entry<K, V>>() {
            @Override
            public Iterator<Entry<K, V>> iterator() {
                return new Ite();
            }

            @Override
            public int size() {
                return size;
            }
        };
    }
    private class BucketIterator{
        private int index = 0;
        public final boolean hasNextBucket() {
            if (index > LENGTH-1){
                return false;
            }
            LinkedHashSet<Entry<K,V>> bucket = null;
            for(int i = index; i < LENGTH-1; i++, index++){
                if (buckets[i] != null && !buckets[i].isEmpty()){
                    bucket = buckets[i];
                    break;
                }
            }
            return bucket != null;
        }

        public final LinkedHashSet<Entry<K, V>> bucket() {
            return buckets[index++];
        }
    }
    private class Ite extends BucketIterator implements Iterator<Entry<K, V>>{
        int cursor = 0;
        private Iterator<Entry<K, V>> ite;
        @Override
        public boolean hasNext() {
            if(cursor < size){
                if(ite == null){
                    if(hasNextBucket()){
                        ite = bucket().iterator();
                    }
                } else {
                    if(!ite.hasNext()&&hasNextBucket()){
                        ite = bucket().iterator();
                    }
                }
                return true;
            }
            return false;
        }

        @Override
        public Entry<K, V> next() {
            if (ite == null){
                throw new NoSuchElementException();
            }
            cursor++;
            return ite.next();
        }
        @Override
        public void remove() {
            if (ite != null){
                ite.remove();
                size--;
                cursor--;
            }

        }
    }
    private class EntryMap implements Entry<K,V>{
        private K key;
        private V value;
        EntryMap(K key, V value){
            this.key = key;
            this.value = value;
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
            if (obj instanceof SimpleHashMap.EntryMap){
                EntryMap entry = (EntryMap) obj;
                return key.equals(entry.key) && value.equals(entry.value);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return key.hashCode() ^ value.hashCode();
        }
    }
}
