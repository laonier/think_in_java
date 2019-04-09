import java.util.*;

public class think {
    public static void main(String[] args) {
        LinkedHashSet<Integer>[] buckets = new LinkedHashSet[3];
        LinkedHashSet<Integer> set0 = new LinkedHashSet<>();
        LinkedHashSet<Integer> set1 = new LinkedHashSet<>();
        LinkedHashSet<Integer> set2 = new LinkedHashSet<>();
        buckets[0] = set0;
        buckets[1] = set1;
        buckets[2] = set2;
        for(LinkedHashSet<Integer> set: buckets){
            System.out.println(set);
        }
        set0.add(0);
        set1.add(1);
        set2.add(2);
        for(LinkedHashSet<Integer> set: buckets){
            System.out.println(set);
        }
        set0.remove(0);
        for(LinkedHashSet<Integer> set: buckets){
            System.out.println(set);
        }
    }
}
