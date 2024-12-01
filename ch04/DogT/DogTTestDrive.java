package ch04.DogT;

public class DogTTestDrive {
    public static void main(String[] args) {
        DogT d = new DogT();
        d.setName("Joy");
        d.setSize(10);

        DogT e = new DogT();
        e.setName("Joy");
        e.setSize(10);

        if (e.equals(d)) {
            System.out.println("Dog of e is compare to Dog to d");
        } else {
            System.out.println("Dog of e is different to Dog of d");
        }
    }
}
