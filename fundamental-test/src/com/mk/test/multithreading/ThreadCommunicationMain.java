package com.mk.test.multithreading;

class Calculator implements Runnable {
    private Calculate calculate;

    Calculator(Calculate calculate){
        this.calculate = calculate;
    }
    public void run(){
        synchronized (calculate) {
            System.out.println("Waiting for calculation..");
            try {
                calculate.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Notified"+Thread.currentThread());
    }
}
class Calculate implements Runnable {
    private int sum = 0;
    public void run(){
        synchronized (this) {
            for(int count = 0; count <= 10 ; count++) {
                sum = sum + count;
            }
            System.out.println(sum);
            notifyAll();
        }
    }
}

public class ThreadCommunicationMain {

    public static void main(String[] args){
        Calculate calculate = new Calculate();
        Thread calculateTh = new Thread(calculate);

        Thread calculatorTh1 = new Thread(new Calculator(calculate));
        calculatorTh1.start();

        Thread calculatorTh2 = new Thread(new Calculator(calculate));
        calculatorTh2.start();

        Thread calculatorTh3 = new Thread(new Calculator(calculate));
        calculatorTh3.start();

        calculateTh.start();
    }
}
