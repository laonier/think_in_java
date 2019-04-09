package common.generator;

/**
 * 类型 字节（一个字节八位bit）
 * byte 1, short 2, int 4, long 8, float 4, double 8, char 2, boolean 1.
 * Byte,    Short,   Integer,   Long,   Float,  Double, Character, Boolean
 */
public class CountingGenerator {

    public static class Boolean implements Generator<java.lang.Boolean> {
        java.lang.Boolean value = false;
        @Override
        public java.lang.Boolean next() {
            value = !value;
            return value;
        }
    }
    static char[] chars = "abcdefghijglmnopqrstuvwxyzABCDEFGHIJGLMNOPQRSTUVWXYZ".toCharArray();
    public static class Character implements Generator<java.lang.Character> {
        private int index = 0;
        @Override
        public java.lang.Character next() {
            index = index % chars.length;
            return chars[index++];
        }
    }
    public static class Byte implements Generator<java.lang.Byte> {
        private byte value;
        @Override
        public java.lang.Byte next() {
            return value++;
        }
    }
    public static class Short implements Generator<java.lang.Short>{
        private short value;
        @Override
        public java.lang.Short next() {
            return value++;
        }
    }
    public static class Integer implements Generator<java.lang.Integer>{
        private int value;
        @Override
        public java.lang.Integer next() {
            return value++;
        }
    }
    public static class Long implements Generator<java.lang.Long>{
        private long value;
        @Override
        public java.lang.Long next() {
            return value++;
        }
    }
    public static class Float implements Generator<java.lang.Float>{
        private float value;
        @Override
        public java.lang.Float next() {
            value += 1.0F;
            return value;
        }
    }
    public static class Double implements Generator<java.lang.Double>{
        private double value;
        @Override
        public java.lang.Double next() {
            value += 1.0D;
            return value;
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
