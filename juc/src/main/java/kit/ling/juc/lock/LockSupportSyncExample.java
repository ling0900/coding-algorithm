package kit.ling.juc.lock;

import java.util.concurrent.locks.LockSupport;

public class LockSupportSyncExample {

    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread 1: Acquired lock and parking...");
                LockSupport.park();  // Thread will be parked (blocked)
                System.out.println("Thread 1: Unparked and exiting...");
            }
        });

        Thread thread2 = new Thread(() -> {
            // Sleep to ensure thread1 has started and acquired the lock
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            System.out.println("Thread 2: Trying to acquire lock...");
            synchronized (lock) {
                System.out.println("Thread 2: Acquired lock.");
            }
        });

        thread1.start();
        thread2.start();

        // Unpark thread1 after some delay
        Thread.sleep(3000);
        System.out.println("Main thread: Unparking thread 1...");
        LockSupport.unpark(thread1);

        thread1.join();
        thread2.join();
    }
}

