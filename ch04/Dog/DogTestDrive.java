package ch04.Dog;

public class DogTestDrive {
    public static void main(String[] args) {

        System.out.println();
        
        Dog one = new Dog();
        one.weight = 70;

        Dog two = new Dog();
        two.weight = 15;

        Dog three = new Dog();
        three.weight = 8;

        one.bark();
        two.bark();
        three.bark();
    }
}
