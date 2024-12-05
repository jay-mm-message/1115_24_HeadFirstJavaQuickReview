package ch15.MultipleThread;

public class Procedure implements Runnable {

    public void prompt(String msg) {
        System.out.println(msg);
    }
    
    @Override
    public void run() {
        for(int i = 0 ; i < 25 ; ++i) {
            try {
                Thread.sleep(1000);
                prompt(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
}
