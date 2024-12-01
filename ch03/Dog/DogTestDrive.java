package ch03.Dog;

public class DogTestDrive {
    public static void main(String[] args) {

        Dog [] pets = new Dog[5];

        pets[0] = new Dog("Buddy");
        pets[1] = new Dog("Max");
        pets[2] = new Dog("Bella");
        pets[3] = new Dog("Charlie");
        pets[4] = new Dog("Daisy");

        int i = 0;
        for(Dog d : pets) {
            System.out.printf("Pet[" + Integer.toString(i) + "]");
            System.out.printf(", It's name: " + d.getName());
            System.out.println();
            i = i + 1;
        }
    }
}
