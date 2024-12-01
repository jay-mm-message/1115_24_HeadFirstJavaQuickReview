package ch03.Hobbit;

public class HobbitTestDrive {
    public static void main(String [] args) {
        System.out.println();

        Hobbit [] h = new Hobbit[3];

        int z = 0;
        while(z < 3) {
            if (z == 0) {
                h[z] = new Hobbit();
                h[z].name = "Bilbo";
            }
            if (z == 1) {
                h[z] = new Hobbit();
                h[z].name = "Frodo";
            }
            if (z == 2) {
                h[z] = new Hobbit();
                h[z].name = "Sam";
            }

            System.out.print(h[z].name + " is a ");
            System.out.println("good Hobbit name");
            z = z + 1;
        }
    }
}
