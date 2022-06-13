package Dream;

import java.util.ArrayList;
import java.util.List;

public class ProblemDemo {

    public static void main(String[] args) {
        SensorsThread pt = new SensorsThread();
        Thread t1 = new Thread(pt, "Sensors");
        Thread t2 = new Thread(new MicroControllerThread(pt), "MicroController");
        t1.start();
        t2.start(); 
    }
}

    class SensorsThread implements Runnable {
        List<Integer> sharedListObj;
        boolean flag;

        SensorsThread() {
            System.out.println("Constructor SensorsThread");
            this.sharedListObj = new ArrayList<Integer>();
            this.flag = true;
        }

        @Override
        public void run() {
            System.out.println("SensorsThread run");
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    System.out.println("Adding to queue - " + Thread.currentThread().getName() + " Oxygen");
                    sharedListObj.add(i);
                }
                if (i == 1) {
                    System.out.println("Adding to queue - " + Thread.currentThread().getName() + " Carbon dioxide");
                }
                if (i == 2) {
                    System.out.println("Adding to queue - " + Thread.currentThread().getName() + " Humidity");
                }
            }
            flag = false;
        }
    }

    class MicroControllerThread implements Runnable {
        SensorsThread pt;

        MicroControllerThread(SensorsThread pt) {
            System.out.println("Consturctor MicroControllerThread");
            this.pt = pt;
        }

        @Override
        public void run() {
            while (this.pt.flag) {
                System.out.println("Busy Waiting");
            }
            System.out.println("MicroController starting");
            for (Integer i : this.pt.sharedListObj) {
                if (i == 0) {
                    System.out.println("Oxygen data Saved");
                }

                else if (i == 1) {
                    System.out.println("Carbon Dioxide data Saved");
                }

                else {
                    System.out.println("Humidity data Saved");
                }
            }
        }
    }
    

