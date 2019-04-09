//producer extends customer super
public class Generic {
    public static void main(String[] args) {
        Plate<? extends Fruit> plate1 = new Plate<>(new Apple());
//        producer extends
        Fruit fruit1 = plate1.getValue();
        plate1.setValue(null);
//        plate1.setValue(new Fruit());
//        plate1.setValue(new Object());
//        plate1.setValue(new Apple());
        Plate<? super Fruit> plate2 = new Plate<>(new Apple());
//        customer super
        plate2.setValue(new Banana());
        plate2.setValue(new Fruit());
//        plate2.setValue(new Food());
//        plate2.setValue(new Object());
//        Fruit fruit2 = plate2.getValue();
        Object fruit3 = plate2.getValue();
        plate2.setValue(null);
    }
}
class Plate<T> {
    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    private T value;
    public Plate(T value){
        this.value = value;
    }
}

//Lev 1
class Food{}

//Lev 2
class Fruit extends Food{}
class Meat extends Food{}

//Lev 3
class Apple extends Fruit{}
class Banana extends Fruit{}
class Pork extends Meat{}
class Beef extends Meat{}

//Lev 4
class RedApple extends Apple{}
class GreenApple extends Apple{}
