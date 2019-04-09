package chapter17.section2.exercises;

import chapter17.section2.Provinces;

import java.util.*;

public class ShuffleTest {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new LinkedList<>();
        String[][] data = Provinces.DATA;
        for (String[] aData : data) {
            list1.add(aData[0]);
            list2.add(aData[0]);
        }
        System.out.println(list1);
        System.out.println(list2);
        System.out.println("shuffle-->");
        Collections.shuffle(list1);
        Collections.shuffle(list2);
        System.out.println(list2);
        System.out.println(list2);
    }
}
