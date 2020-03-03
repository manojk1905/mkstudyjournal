package com.mk.test.designpattern.creational;

import java.io.Serializable;

public class SingletonPattern {
    public static void main(String[] args){
        Thread th1 = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Singleton.getInstance());
                System.out.println(SingletonEnum.INSTANCE.getValue());
                SingletonEnum.INSTANCE.setValue(2);
                System.out.println(SingletonEnum.INSTANCE.getValue());
            }
        });

        Thread th2 = new Thread(new Runnable() {
            public void run() {
                System.out.println(Singleton.getInstance());
                System.out.println(SingletonEnum.INSTANCE.getValue());
                SingletonEnum.INSTANCE.setValue(2);
                System.out.println(SingletonEnum.INSTANCE.getValue());
            }
        });
        //System.out.println(SingletonPattern.getInstance());

        th1.start();
        th2.start();
    }
}

final class Singleton implements Serializable {
    private static Singleton instance;

    private Singleton() {
    }
    /**
     * here we are creating instance with double check locking.
     * And also using volatile class instance variable to
     * avoid partial created object and memory leak problem.
     * @return
     */
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (SingletonPattern.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    protected Object readResolve() {
        return instance;
    }

}

enum SingletonEnum {
    INSTANCE;
    int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

