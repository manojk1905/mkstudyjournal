package com.mk.test.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class EvenOddPrinterMain {

    private static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) {
        Runnable print = () -> {
            while (atomicInteger.get() < 20) {
                synchronized (atomicInteger) {
                    if (atomicInteger.get() % 2 == 1 && "Odd".equals(Thread.currentThread().getName())) {
                        System.out.println(atomicInteger.getAndIncrement());
                    } else if (atomicInteger.get() % 2 == 0 && "Even".equals(Thread.currentThread().getName())) {
                        System.out.println(atomicInteger.getAndIncrement());
                    }
                }
            }
        };
        Thread odd = new Thread(print);
        odd.setName("Odd");
        odd.start();

        Thread even = new Thread(print);
        even.setName("Even");
        even.start();
    }
}
