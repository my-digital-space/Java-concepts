package org.demo.concepts.threadcommunication.demo1;

public class Producer implements Runnable {
    private SharedResource resource;

    public Producer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            resource.produce(i);
            try {
                Thread.sleep(500); // Simulate time taken to produce data
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
