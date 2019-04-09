package chapter17.section9.exercises;

import common.generator.Generator;
import common.generator.MapGenerator;

import java.util.Iterator;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
//        test(new SlowerMap<>());
//        test(new SimpleHashMap<>());
        test(new FullSimpleHashMap<>());
    }
    public static void test(Map<Integer,String> map) {
        Generator<Map<Integer, String>> gen = MapGenerator.map(20);
        System.out.println(map.getClass().getSimpleName());
        map.putAll(gen.next());
        printKeys(map);
        // Producing a Collection of the values:
        System.out.println("Values: " + map.values());
        System.out.println(map);
        System.out.println("map.containsKey(11): " + map.containsKey(11));
        System.out.println("map.get(11): " + map.get(11));
        System.out.println("map.containsValue(\"f\"): " + map.containsValue("f"));
        Iterator<Integer> ite = map.keySet().iterator();
        Integer key = null;
        if (ite.hasNext()){
            key = ite.next();
        }
        System.out.println("First key in map: " + key);
        map.remove(key);
        printKeys(map);
        map.clear();
        System.out.println("map.isEmpty(): " + map.isEmpty());
        map.putAll(MapGenerator.mapDefault(10));
// Operations on the Set change the Map:
        System.out.println(map);
        System.out.println(map.keySet());
        map.keySet().removeAll(map.keySet());
        System.out.println("map.isEmpty(): " + map.isEmpty());
        System.out.println(map);
    }
    private static void printKeys(Map<Integer,String> map){
        // Map has 'Set' behavior for keys:
        System.out.println("Size = " + map.size());
        System.out.println("Keys: " + map.keySet());
    }
}
