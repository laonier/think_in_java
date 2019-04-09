package chapter17.section8;

import common.generator.CountingGenerator;
import common.generator.Generator;
import common.generator.MapGenerator;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        Generator<Map<Integer, String>> gen1 = MapGenerator.map(new CountingGenerator.Integer(),
                new CountingGenerator.String(1), 10);
        LinkedHashMap<Integer, String> map1 = new LinkedHashMap<>(gen1.next());
        System.out.println(map1);
        for(int i = 0; i < 6; i++){
            map1.get(i);
        }
        System.out.println(map1);
        System.out.println(" Open LRU");
        Generator<Map<Integer, String>> gen2 = MapGenerator.map(new CountingGenerator.Integer(),
                new CountingGenerator.String(1), 10);
        LinkedHashMap<Integer, String> map2 = new LinkedHashMap<>(11, 0.75f, true);
        gen2.next();
        map2.putAll(gen2.next());
        System.out.println(map2);
        for(int i = 10; i < 16; i++){
            map2.get(i);
        }
        System.out.println(map2);
        map2.get(10);
        System.out.println(map2);
    }
}
