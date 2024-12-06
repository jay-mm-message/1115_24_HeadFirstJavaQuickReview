package ch15.TcpSocket2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Tools {
    public void prompt(String msg) {
        System.out.println(msg);
    }
    public BufferedReader streamToBuff(InputStream input) {
        InputStreamReader inputStreamReader = new InputStreamReader(input);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        return bufferedReader;
    }
}
