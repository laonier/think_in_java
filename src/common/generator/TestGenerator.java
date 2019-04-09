package common.generator;

public class TestGenerator {
    public static void main(String[] args) {
//        test(CountingGenerator.class);
        test(RandomGenerator.class);
    }
    public static void test(Class cla) {
        for(Class gen: cla.getClasses()){
            System.out.print(gen.getSimpleName() + ": ");
            if (isInterface(gen, Generator.class)){
                try {
                    generator((Generator)gen.newInstance(), 10);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void generator(Generator gen, int quantity) {
        for(int i = 0; i < quantity; i++) {
            System.out.print(gen.next() + " ");
        }
        System.out.println(" ");
    }
    public static boolean isInterface(Class target, Class inter){
        Class[] classes = target.getInterfaces();
        for(Class c: classes){
            if (c.equals(inter)){
                return true;
            }
        }
        return false;
    }
}
