package chapter17.section7;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>(10, Comparator.naturalOrder());
        queue.add(1);
        queue.add(4);
        queue.add(6);
        queue.add(3);
        System.out.println(queue);
    }

}


