package ch06.Animal;

public class Dog extends Canine {
    @Override
    public void makeNoise() {};
    @Override
    public void eat() {
        System.out.println("Dog: eat.");
    };
}
