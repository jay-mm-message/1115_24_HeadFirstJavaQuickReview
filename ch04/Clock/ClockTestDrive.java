package ch04.Clock;

public class ClockTestDrive {
    public static void main(String[] args) {
        Clock c = new Clock();
        c.setTime("12345");
        
        String tod = new String(c.getTime());
        System.out.println("time: " + tod);
    }
}
