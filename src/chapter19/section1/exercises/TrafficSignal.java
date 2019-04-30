package chapter19.section1.exercises;

import static chapter19.section1.exercises.Signal.*;
public class TrafficSignal {
    private Signal color = RED;
    public void change() {
        switch (color) {
            case RED: color = GREEN;break;
            case YELLOW: color = RED;break;
            case GREEN: color = YELLOW;break;
        }
    }

    @Override
    public String toString() {
        return "The traffic signal is " + color;
    }

    public static void main(String[] args) {
        TrafficSignal t = new TrafficSignal();
        for (int i = 0 ; i < 7; i++) {
            System.out.println(t);
            t.change();
        }
    }
}
