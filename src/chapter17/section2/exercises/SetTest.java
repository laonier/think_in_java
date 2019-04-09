package chapter17.section2.exercises;

import chapter17.section2.Provinces;

import java.util.*;

public class SetTest {
    public static void main(String[] args) {
        List<String> names = Provinces.provincialCapital();
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new LinkedHashSet<>();
        Set<String> set3 = new TreeSet<>();
        set1.addAll(names);
        set1.addAll(names);
        set2.addAll(names);
        set2.addAll(names);
        set3.addAll(names);
        set3.addAll(names);
        System.out.println(names);
        System.out.println(set1);
        System.out.println(set2);
        System.out.println(set3);
    }
}
