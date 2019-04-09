package chapter17.section2;

import common.generator.RandomGenerator;

import java.util.LinkedHashSet;
import java.util.Set;

public class CollectionDataTest {
    public static void main(String[] args) {
        Set sets = new LinkedHashSet<>(new CollectionData<>(new RandomGenerator.String(10),
                10));
        System.out.println(sets);
        sets.addAll(CollectionData.list(new RandomGenerator.Integer(), 19));
        System.out.println(sets);
    }
}
