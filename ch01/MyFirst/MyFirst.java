package ch01.MyFirst;

public class MyFirst {
    public static void p(String msg) {
        System.out.println(msg);
    }
    public static void main(String [] args) {
        // p("I Rule!");
        // p("The World");
        DooBee(2);
    }

    public static void DooBee(int times) {
        while(times > 0) {
            System.out.print("Doo");
            System.out.print("Bee");
            
            times = times - 1;
        }

        if (times == 0) {
            System.out.println("Do");
        }
    }
}
