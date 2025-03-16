package org.demo.string_immutable1;

public class StringTask implements Runnable {
    private final String data;

    public StringTask(String data) {
        this.data = data;
    }

    @Override
    public void run() {
        // Each thread reads the shared string
        System.out.println(Thread.currentThread().getName() + " reads: " + data);

        // Attempt to "modify" the string.
        // This creates a new String instance; the original remains unchanged.
        String modified = data + " - Modified by " + Thread.currentThread().getName();
        System.out.println(Thread.currentThread().getName() + " creates: " + modified);

        // Verify the original string is still unchanged.
        System.out.println(Thread.currentThread().getName() + " original remains: " + data);

        System.out.println("\n");
    }
}
