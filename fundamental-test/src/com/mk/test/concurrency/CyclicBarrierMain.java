package com.mk.test.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierMain {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
        public void run() {
            System.out.println("Reached barrier point::");
        }
    });

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {

        Runnable print = ()-> {
            System.out.println(Thread.currentThread().getName()+ " : Printing");
            try {
                cyclicBarrier.await();
                Thread.sleep(1000);
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        };

        Thread th1 = new Thread(print);
        th1.setName("Thread-1");
        th1.start();

        Thread th2 = new Thread(print);
        th2.setName("Thread-2");
        th2.start();

        Thread th3 = new Thread(print);
        th3.setName("Thread-3");
        th3.start();

        System.out.println(cyclicBarrier.getNumberWaiting());
        Thread.sleep(3000);
        System.out.println("Reusing Cyclic Barrier..");

        Thread th4 = new Thread(print);
        th4.setName("Thread-4");
        th4.start();

        Thread th5 = new Thread(print);
        th5.setName("Thread-5");
        th5.start();

        Thread th6 = new Thread(print);
        th6.setName("Thread-6");
        th6.start();

    }
}
