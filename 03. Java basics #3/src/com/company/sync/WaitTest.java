package com.company.sync;


public class WaitTest {

    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();

        synchronized (worker) {
            worker.wait();
        }
    }

}


class Worker {

    boolean ready = false;

    public void prepareData() {
        // some long operation
        synchronized (this) {
            ready = true;
            notify();
        }

    }

    public void sendData() throws InterruptedException {

        synchronized (this) {
            if (!ready) {
                wait();
            }
            // send data
        }

    }


}
