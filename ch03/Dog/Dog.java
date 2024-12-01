package ch03.Dog;

public class Dog {
    String name;

    public String getName() {
        return this.name;
    }
    
    Dog(String n) {
        this.name = new String(n);
    }
}
