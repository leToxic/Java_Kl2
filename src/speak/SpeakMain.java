package speak;

import java.util.Random;

public class SpeakMain {
    public static void main(String[] args) {
        Speaker[] speakers = new Speaker[100];
        Random rnd = new Random();

        for (int i = 0; i < speakers.length; i++) {
            int test = rnd.nextInt(3);
            switch (test) {
                case 0 -> speakers[i] = new Dog();
                case 1 -> speakers[i] = new Cat();
                case 2 -> speakers[i] = new Person();
            }
        }

        for (Speaker i : speakers) {
            try {
                System.out.println(i.speak());
            } catch (MuteException me) {
                System.out.println(me.getMessage());
            }
        }
    }
}