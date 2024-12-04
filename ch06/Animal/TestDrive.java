package ch06.Animal;

import java.util.ArrayList;

public class TestDrive {
    public static void main(String[] args) {
        Animal [] pets = new Animal[6];
        pets[0] = new Cat();
        pets[1] = new Dog();
        pets[2] = new Lion();
        pets[3] = new Hippopotamus();
        pets[4] = new Tiger();
        pets[5] = new Wolf();

        for(Animal a : pets) {
            System.out.println(a.getClass().getName());
        }
        System.out.println();

        ArrayList<Animal> pets2 = new ArrayList<Animal>();
        pets2.add(new Cat());
        pets2.add(new Tiger());
        pets2.add(new Lion());
        pets2.add(new Hippopotamus());
        pets2.add(new Dog());
        pets2.add(new Wolf());

        for(Animal a : pets2) {
            System.out.println(a.getClass().getName());
        }
        System.out.println();

        for(Animal a : pets2) {
            a.eat();
        }
        System.out.println();
    }
}
