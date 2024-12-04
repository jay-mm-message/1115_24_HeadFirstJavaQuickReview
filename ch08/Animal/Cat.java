package ch08.Animal;

public class Cat extends Feline {
    @Override
    public void makeNoise() {};
    @Override
    public void eat() {
        System.out.println("Cat: eat.");
    }
    @Override
    public void sleep() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sleep'");
    };
}
