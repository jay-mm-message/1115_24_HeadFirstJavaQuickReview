package ch01.Exercise;

public class Shuffle1 {
    public static void p(String msg) {
        System.out.print(msg);
    }
    public static void main(String [] args) {

        int x = 3;
        if (x > 2) {
            p("a");
        }
        x = x - 1;
        p("-");
        if (x == 2) {
            p("b c");
        }
        x = x - 1;
        p("-");
        if (x == 1) {
            p("d");
            x = x - 1;
        }
        
        p("\n");
    }
}
