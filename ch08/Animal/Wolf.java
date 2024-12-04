package ch08.Animal;

public class Wolf extends Canine {
    @Override
    public void makeNoise() {};
    @Override
    public void eat() {
        System.out.println("Wolf: eat.");
    }
    @Override
    public void sleep() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sleep'");
    };
}
