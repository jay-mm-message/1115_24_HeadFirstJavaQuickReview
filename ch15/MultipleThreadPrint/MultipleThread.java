package ch15.MultipleThreadPrint;

public class MultipleThread {
    public void go() {
        Printer printer = new Printer();

        Thread t1 = new Thread(printer);
        t1.setName("Sandy");
        Thread t2 = new Thread(printer);
        t2.setName("John");
        Thread t3 = new Thread(printer);
        t3.setName("Tom");
        Thread t4 = new Thread(printer);
        t4.setName("Suse");

        t1.start();
        t2.start();
        t3.start();
        t4.start(); 
    }
}
