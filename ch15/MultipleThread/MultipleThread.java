package ch15.MultipleThread;

import java.util.ArrayList;

public class MultipleThread {
    public void go() {

        Procedure procedure = new Procedure();

        int procedureMax = 3;
        ArrayList<Thread> threadsList;
        threadsList = new ArrayList<Thread>();
        for(int procedureNum = 0 ; procedureNum < procedureMax ; ++procedureNum) {
            threadsList.add(new Thread(procedure));
            threadsList.get(procedureNum).setName("procedure: " + Integer.toString(procedureNum));
            threadsList.get(procedureNum).start();
        }
    }
}
