package common.generator;

import java.util.Collection;

public class GeneratorUtil {
    public static <T> void fill(Collection<T> col, int quantity, Class<? extends Generator<T>> cla){
        System.out.println(cla.getSimpleName());
        for(int i = 0; i < quantity; i++){
            try {
                col.add(cla.newInstance().next());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
