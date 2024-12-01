package ch04.XCopy;

public class XCopyTestDrive {
    public static void main(String[] args) {
        int orig = 42;
        XCopy x = new XCopy();
        int y = x.go(orig);
        System.out.println(orig + " " + Integer.toString(y));
    }
}
