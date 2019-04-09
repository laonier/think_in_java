package chapter17.section7.exercises;


import common.generator.Generator;
import common.generator.GeneratorUtil;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class RandomInteger implements Comparable<RandomInteger>, Generator<RandomInteger> {
    private Integer value;

    public RandomInteger(){
        Random random = new Random();
        value = random.nextInt(100);
    }

    @Override
    public int compareTo(RandomInteger o) {
        return o.value.compareTo(value);
    }

    @Override
    public RandomInteger next() {
        return new RandomInteger();
    }

    @Override
    public String toString() {
        return value + "";
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof RandomInteger && value.equals(((RandomInteger)obj).value);
    }

    public static void main(String[] args) {
        Queue<RandomInteger> queue = new PriorityQueue<>();
        GeneratorUtil.fill(queue, 10, RandomInteger.class);
        System.out.println(queue);
        System.out.println("peek queue ");
        while (queue.peek() != null){
            System.out.print(queue.remove() + " ");
        }
    }
}
