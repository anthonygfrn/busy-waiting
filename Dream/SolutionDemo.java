package Dream;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionDemo {

    public static void main(String[] args) {
        Queue<Integer> sharedListObj = new LinkedList<Integer>();
        Thread t1 = new Thread(new SensorClass(sharedListObj), "Sensors");
        Thread t2 = new Thread(new MicroControllerClass(sharedListObj), "MicroController");
        t1.start();
        t2.start(); 
    }
    
}

class SensorClass implements Runnable {
    Queue<Integer> sharedListObj;

    SensorClass(Queue<Integer> sharedListObj) {
        this.sharedListObj = sharedListObj;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            synchronized (sharedListObj) {
                while (sharedListObj.size() >= 1) {
                    try {
                        sharedListObj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                    if (i == 0) {
                        System.out.println("Adding Oxygen to queue - " + Thread.currentThread().getName() + "Oxygen");
                        ++i;
                    }
                    else if (i == 1) {
                        System.out.println("Adding CO2 to queue - " + Thread.currentThread().getName() + "CO2");
                        ++i;
                    }
                    else if (i == 2) {
                        System.out.println("Adding Humidity to queue - " + Thread.currentThread().getName() + "Humidity");
                        ++i;
                    }
                    sharedListObj.add(i);
                    sharedListObj.notify();
                    if (i > 2)
                    break; 
                }
    }
    }
}

class MicroControllerClass implements Runnable {
    Queue<Integer> sharedListObj;

    MicroControllerClass(Queue<Integer> sharedListObj) {
        this.sharedListObj = sharedListObj;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (sharedListObj) {
                while (sharedListObj.size() >= 1) {
                    try {
                        sharedListObj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int val = sharedListObj.remove();
                System.out.println("Getting Data" + Thread.currentThread().getName() + " " + val);
                if (val == 3){
                    System.out.println();
                    System.out.println("Sending data to database");
                    break;
                }
                sharedListObj.notify();
            }
        }
    }
}
