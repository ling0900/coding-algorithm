package kit.ling.juc.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.LockSupport;

public class LockSupportExample {

    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            lock.lock();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                System.out.println("Thread 1: Acquired lock and parking...");
                LockSupport.park();  // Thread will be parked (blocked)
                System.out.println("Thread 1: Unparked and exiting...");
            } finally {
                lock.unlock();
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
            lock.lock();
            try {
                System.out.println("Thread 2: Acquired lock.");
            } finally {
                lock.unlock();
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

