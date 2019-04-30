package common;

import java.util.Random;

public class Enums {
    private static Random RANDOM = new Random(47);
    private static  <T> T random(T[] values) {
        return values[RANDOM.nextInt(values.length)];
    }
    public static <T extends Enum<T>> T next(Class<T> tc){
        return random(tc.getEnumConstants());
    }
}
