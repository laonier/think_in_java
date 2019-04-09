package common.generator;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapGenerator<K,V> implements Generator<Map<K, V>> {
    private final Generator<K> keyGen;
    private final Generator<V> valueGen;
    private final int quantity;
    public MapGenerator(Generator<K> keyGen, Generator<V> valueGen,
                        int quantity){
        this.keyGen = keyGen;
        this.valueGen = valueGen;
        this.quantity = quantity;
    }
    @Override
    public Map<K, V> next() {
        Map<K, V> map = new LinkedHashMap<>();
        for(int i = 0; i < quantity; i++){
            map.put(keyGen.next(), valueGen.next());
        }
        return map;
    }
    public static <K,V> Generator<Map<K, V>> map(Generator<K> keyGen, Generator<V> valueGen,
                                              int quantity){
        return new MapGenerator<>(keyGen, valueGen, quantity);
    }
    public static Generator<Map<Integer, String>> map(int quantity){
        return MapGenerator.map(new CountingGenerator.Integer(),
                new CountingGenerator.String(1), quantity);
    }
    public static Map<Integer, String> mapDefault(int quantity){
        return MapGenerator.map(new CountingGenerator.Integer(),
                new CountingGenerator.String(1), quantity).next();
    }
}
