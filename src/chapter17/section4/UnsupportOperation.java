package chapter17.section4;

import java.util.*;

public class UnsupportOperation {
    static void test(String message, List<String> list){
        System.out.println("----" + message + "----");
        try{
            list.add("X");
        }catch (Exception e){
            System.out.println("add(e): " + e);
        }
        try{
            list.add(1, "X");
        }catch (Exception e){
            System.out.println("add(index, element): " + e);
        }
        try{
            list.set(1, "M");
        }catch (Exception e){
            System.out.println("set: " + e);
        }

        try{
            list.remove("A");
        }catch (Exception e){
            System.out.println("remove(element): " + e);
        }
        try{
            list.remove(1);
        }catch (Exception e){
            System.out.println("remove(index): " + e);
        }
        List<String> subList = list.subList(1, 2);
        try{
            list.removeAll(subList);
        }catch (Exception e){
            System.out.println("removeAll: " + e);
        }
        try{
            list.addAll(subList);
        }catch (Exception e){
            System.out.println("addAll: " + e);
        }
        try{
            list.clear();
        }catch (Exception e){
            System.out.println("clear: " + e);
        }
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList( "A B C D E F G H I J K L M N O P Q R S T U String W X Y Z".split(" "));
        test("Arrays.asList", list);
        test("ArrayList", new ArrayList<>(list));
        test("unmodifiableList", Collections.unmodifiableList(new ArrayList<>(list)));
    }
}
