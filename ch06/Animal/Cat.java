package ch06.Animal;

public class Cat extends Feline {
    @Override
    public void makeNoise() {};
    @Override
    public void eat() {
        System.out.println("Cat: eat.");
    };
}
