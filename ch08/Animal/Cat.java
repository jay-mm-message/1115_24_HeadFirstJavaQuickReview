package ch08.Animal;

public class Cat extends Feline implements Pet {
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
    }
    @Override
    public void beFriendly() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'beFriendly'");
    }
    @Override
    public void play() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'play'");
    }
    
}
