package com.mk.test.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class BlockingQueueMain {

    private static BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(1);

    public static void main(String[] args) {

        Runnable producer = () -> {
            int count = 0;
            while(true) {
                try {
                    Thread.sleep(1000);
                    count += 1;
                    System.out.println("Produced::" + count);
                    blockingQueue.put(count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable consumer = () -> {
            while(true) {
                try {
                    Thread.sleep(1000);
                    System.out.println("Consumed::" +blockingQueue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread producerTh = new Thread(producer);
        producerTh.setName("Producer");
        producerTh.start();

        Thread consumerTh = new Thread(consumer);
        consumerTh.setName("Consumer");
        consumerTh.start();
    }
}
