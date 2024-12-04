package ch06.Animal;

public class Lion extends Feline {
    @Override
    public void makeNoise() {};
    @Override
    public void eat() {
        System.out.println("Lion: eat.");
    };
}
