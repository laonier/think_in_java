package chapter17.section9;

import java.util.*;

public class SlowMap<K,V> extends AbstractMap<K,V> {
    private List<K> keys = new ArrayList<>();
    private List<V> values = new ArrayList<>();

    @Override
    public V get(Object key) {
        if(!keys.contains(key)){
            return null;
        }
        return values.get(keys.indexOf(key));
    }

    @Override
    public V put(K key, V value) {
        V result = get(key);
        if(result != null){
            values.set(keys.indexOf(key), value);
        } else {
            keys.add(key);
            values.add(value);
        }
        return result;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> entryMaps = new HashSet<>();
        Iterator<K> keyIte = keys.iterator();
        Iterator<V> valueIte = values.iterator();
        while (keyIte.hasNext()){
            entryMaps.add(new EntryMap(keyIte.next(), valueIte.next()));
        }
        return entryMaps;
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
    }
}
