package chapter17.section2;

import common.generator.Generator;
import common.generator.RandomGenerator;

import java.util.Iterator;

class Letters implements Generator<Pair<Integer, String>>, Iterable<Integer>{
    private int size = 7;
    private int key;
    private char value = 'a';
    @Override
    public Pair<Integer, String> next() {
        return new Pair<>(key++, String.valueOf(value++));
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return key < size;
            }

            @Override
            public Integer next() {
                return key++;
            }
        };
    }
}
public class MapDataTest {
    public static void main(String[] args) {
        System.out.println(MapData.map(new Letters(), 10));
        System.out.println(MapData.map(new RandomGenerator.Integer(),new RandomGenerator.String(3), 10));
        System.out.println(MapData.map(new RandomGenerator.Integer(), "Pop", 10));
        System.out.println(MapData.map(new Letters(), new RandomGenerator.String(3)));
    }
}
