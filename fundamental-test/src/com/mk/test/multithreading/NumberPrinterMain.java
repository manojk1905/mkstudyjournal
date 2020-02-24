package com.mk.test.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class NumberPrinterMain {
    private static AtomicInteger atomicInteger = new AtomicInteger(1);
    public static void main(String[] args) throws InterruptedException {
        Runnable printer = () -> {
            while (atomicInteger.get() < 20) {
                if(atomicInteger.get() % 4 == 1 && "Thread-1".equals(Thread.currentThread().getName())) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+ "->"+ atomicInteger.getAndIncrement());
                } else if(atomicInteger.get() % 4 == 2 && "Thread-2".equals(Thread.currentThread().getName())) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+ "->"+ atomicInteger.getAndIncrement());
                } else if(atomicInteger.get() % 4 == 3 && "Thread-3".equals(Thread.currentThread().getName())) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+ "->"+ atomicInteger.getAndIncrement());
                } else if(atomicInteger.get() % 4 == 0 && "Thread-4".equals(Thread.currentThread().getName())) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+ "->"+ atomicInteger.getAndIncrement());
                }
            }
        };

        Thread thread1 = new Thread(printer);
        thread1.setName("Thread-1");
        thread1.start();

        Thread thread2 = new Thread(printer);
        thread2.setName("Thread-2");
        thread2.start();

        Thread thread3 = new Thread(printer);
        thread3.setName("Thread-3");
        thread3.start();

        Thread thread4 = new Thread(printer);
        thread4.setName("Thread-4");
        thread4.start();
    }
}
