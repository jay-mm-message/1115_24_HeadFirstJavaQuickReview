package ch08.Animal;

abstract public class Animal {
    String picture;
    String food;
    String hunger;
    String boundaries;
    String location;

    abstract public void makeNoise();
    public void eat() {
        System.out.println("Animal: eat.");
    };
    abstract public void sleep();
    abstract public void roam();
}
