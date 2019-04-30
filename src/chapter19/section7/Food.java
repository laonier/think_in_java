package chapter19.section7;

public interface Food {
    enum Appetizer implements Food{
        SALAD, SOUP, SPRING_ROLLS
    }
    enum MainCourse implements Food {
        LASAGNE, BURRITO, HUMMOUS
    }
}
