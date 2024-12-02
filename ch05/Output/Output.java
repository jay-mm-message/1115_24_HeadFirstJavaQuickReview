package ch05.Output;

public class Output {
    public void go() {
        int y = 7;
        for(int x = 1 ; x < 9 ; ++x) {
            y++;
            if (x > 4) {
                System.out.print(++y + "\\");
            }
            if (y > 14) {
                System.out.println(" x = " + x);
                break;
            }
        }
    }
}
/*
 * y = 7
 * x = 1, 2, 3, 4, 5, 6, 7, 8
 *  y = 8, 9, 10, 11,
 *                      13, 15, 17,
 */