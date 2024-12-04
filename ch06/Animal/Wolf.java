package ch06.Animal;

public class Wolf extends Canine {
    @Override
    public void makeNoise() {};
    @Override
    public void eat() {
        System.out.println("Wolf: eat.");
    };
}
