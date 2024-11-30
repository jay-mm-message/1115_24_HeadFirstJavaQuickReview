package ch03.Cup;

public class CupTestDrive {
    public static void main(String[] args) {
        Cup c1 = new Cup("Water");
        Cup c2 = new Cup("Coffee");
        Cup c3 = new Cup("Soft drink");

        System.out.println("Display the content of c1: " + c1.showContent());
        System.out.println("Display the content of c2: " + c2.showContent());
        System.out.println("Display the content of c3: " + c3.showContent());

        System.out.println("Assign the value of variable c3 to variable c2.");
        c2 = c3;
        System.out.println("Display the content of c1: " + c1.showContent());
        System.out.println("Display the content of c2: " + c2.showContent());
        System.out.println("Display the content of c3: " + c3.showContent());
    }
}
