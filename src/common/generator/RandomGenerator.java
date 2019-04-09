package common.generator;

import java.util.Random;

public class RandomGenerator {
    private static Random random = new Random(312);
    public static class Boolean implements Generator<java.lang.Boolean> {
        @Override
        public java.lang.Boolean next() {
            return random.nextBoolean();
        }
    }
    public static class Character implements Generator<java.lang.Character> {
        @Override
        public java.lang.Character next() {
            return CountingGenerator.chars[random.nextInt(CountingGenerator.chars.length)];
        }
    }
    public static class Byte implements Generator<java.lang.Byte> {
        @Override
        public java.lang.Byte next() {
            return (byte)random.nextInt();
        }
    }
    public static class Short implements Generator<java.lang.Short>{
        @Override
        public java.lang.Short next() {
            return (short)random.nextInt();
        }
    }
    public static class Integer implements Generator<java.lang.Integer>{
        @Override
        public java.lang.Integer next() {
            return random.nextInt();
        }
    }
    public static class Long implements Generator<java.lang.Long>{
        @Override
        public java.lang.Long next() {
            return random.nextLong();
        }
    }
    public static class Float implements Generator<java.lang.Float>{
        @Override
        public java.lang.Float next() {
            return random.nextFloat();
        }
    }
    public static class Double implements Generator<java.lang.Double>{
        @Override
        public java.lang.Double next() {
            return random.nextDouble();
        }
    }
    public static class String implements Generator<java.lang.String> {
        private int size;
        private Generator<java.lang.Character> gen = new Character();
        public String() {
            size = 7;
        }
        public String(int size){
            this.size = size;
        }
        @Override
        public java.lang.String next() {
            char[] buffer = new char[size];
            for(int i = 0; i < size; i++) {
                buffer[i] = gen.next();
            }
            return new java.lang.String(buffer);
        }
    }
}
