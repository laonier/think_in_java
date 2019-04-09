package chapter17.section2.exercises;

import chapter17.section2.Provinces;

import java.util.*;

public class ProvinceTest {
    public static void main(String[] args) {
        TreeMap<String, String> provinces = new TreeMap<>(Provinces.province());
        String head = null;
        for (String key : provinces.keySet()){
            if (key.startsWith("J")){
                head = key;
                break;
            }
        }
        System.out.println(provinces.headMap(head));
    }
}
