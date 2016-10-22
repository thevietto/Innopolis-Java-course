package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	// write your code here

        System.out.println(Thread.currentThread().getName());

        Thread t1 = new Thread(new MyRunnable());
        Thread t2 = new MyThread();

        t1.start();
        t1.join();

        System.out.println("Продолжаем");

    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello from " + Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread extends Thread {

    @Override
    public void run() {
        while (true) {
            System.out.println("Hello from " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
