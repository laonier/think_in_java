package chapter19;

import chapter19.section1.Spiciness;

public class main {
    public static void main(String[] args) {
        for (Spiciness spi: Spiciness.values()) {
            System.out.println("name = " + spi.name());
            System.out.println("ordinal = " + spi.ordinal());
            System.out.println("================== ");
        }
    }
}
