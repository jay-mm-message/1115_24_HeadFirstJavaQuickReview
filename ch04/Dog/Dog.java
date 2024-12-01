package ch04.Dog;

public class Dog {
    int weight;

    public void bark() {
        if (weight > 60) {
            System.out.println("Woof! Woof!");
        } else if (weight > 14) {
            System.out.println("Ruff! Ruff!");
        } else {
            System.out.println("Yip! Yip!");
        }
    }
}
