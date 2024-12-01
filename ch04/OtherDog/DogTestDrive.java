package ch04.OtherDog;

public class DogTestDrive {
    public static void main(String[] args) {
        System.out.println();

        Dog [] pets = new Dog[3];

        for(int i = 0 ; i < 3 ; ++i) {
            pets[i] = new Dog();
            pets[i].setSize(i + 10);
        }

        for(int i = 0 ; i < 3 ; ++i) {
            System.out.print("Pet[" + Integer.toString(i) + "]:");
            System.out.print(pets[i].getSize());
            System.out.print(", It's name: ");
            System.out.print(pets[i].getName());
            System.out.println();
        }
    }
}
