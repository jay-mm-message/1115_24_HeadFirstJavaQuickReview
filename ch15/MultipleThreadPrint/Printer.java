package ch15.MultipleThreadPrint;

public class Printer implements Runnable {

    private int paperNum;

    public int getPaperNum() {
        return paperNum;
    }

    public void setPaperNum(int paperNum) {
        if (paperNum <= 0) {
            System.out.println("Incorrect paper number !!!");
            return;
        }

        this.paperNum = paperNum; 
    }

    public Printer() {
        this.setPaperNum(10);
    }

    public synchronized void decrement() {
        String userName = new String(Thread.currentThread().getName());

        if (getPaperNum() > 0) {
            this.paperNum = this.paperNum - 1;
            setPaperNum(paperNum);
            System.out.println(userName + ", The paper number is " + getPaperNum());
        } else {
            System.out.println("Oh no, " + userName + ", the paper number is not enough.");
        }
    }

    @Override
    public void run() {
        for(int i = 0 ; i < 5 ; ++i) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            decrement();
        }
    }
}
