package chapter17.section2;

import common.generator.Generator;

import java.util.LinkedHashMap;

public class MapData<K,V> extends LinkedHashMap<K,V> {
    private MapData(Generator<Pair<K, V>> generator, int quantity){
        for(int i = 0; i < quantity; i++){
            Pair<K,V> pair = generator.next();
            put(pair.key, pair.value);
        }
    }
    private MapData(Generator<K> genK, Generator<V> genV, int quantity){
        for(int i = 0; i < quantity; i++){
            put(genK.next(), genV.next());
        }
    }
    private MapData(Generator<K> genK, V value, int quantity){
        for(int i = 0; i < quantity; i++){
            put(genK.next(), value);
        }
    }
    private MapData(Iterable<K> iteK, Generator<V> genV){
        for(K key: iteK){
            put(key, genV.next());
        }
    }
    public static <K,V> MapData<K,V> map(Generator<Pair<K,V>> generator, int quantity){
        return new MapData<>(generator, quantity);
    }
    public static <K,V> MapData<K,V> map(Generator<K> genK, Generator<V> genV, int quantity){
        return new MapData<>(genK, genV, quantity);
    }
    public static <K,V> MapData<K,V> map(Generator<K> genK, V value, int quantity){
        return new MapData<>(genK, value, quantity);
    }
    public static <K,V> MapData<K,V> map(Iterable<K> iteK, Generator<V> genV){
        return new MapData<>(iteK, genV);
    }
}
