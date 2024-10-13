package org.demo.concepts.threadcommunication.demo1;

public class Consumer implements Runnable {
    private SharedResource resource;

    public Consumer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            resource.consume();
            try {
                Thread.sleep(1000); // Simulate time taken to consume data
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
