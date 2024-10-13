package org.demo.concepts.threadcommunication.demo1;

public class SharedResource {
    private int data;
    private boolean dataAvailable = false;

    // Producer thread will use this method to produce data
    public synchronized void produce(int value) {
        while (dataAvailable) {
            try {
                wait(); // Wait until data is consumed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        data = value;
        System.out.println("Produced: " + value);
        dataAvailable = true;
        notify(); // Notify the consumer that data is available
    }

    // Consumer thread will use this method to consume data
    public synchronized void consume() {
        while (!dataAvailable) {
            try {
                wait(); // Wait until data is produced
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Consumed: " + data);
        dataAvailable = false;
        notify(); // Notify the producer that data is consumed
    }
}
