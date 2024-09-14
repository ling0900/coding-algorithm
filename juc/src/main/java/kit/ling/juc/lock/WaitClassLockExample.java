package kit.ling.juc.lock;

public class WaitClassLockExample {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            synchronized (WaitClassLockExample.class) {
                try {
                    System.out.println("Thread 1: Acquired class lock and calling wait...");
                    WaitClassLockExample.class.wait();  // Releases class lock and waits
                    System.out.println("Thread 1: Resumed after wait");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            // Sleep to ensure thread1 has started and acquired the lock
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            System.out.println("Thread 2: Trying to acquire class lock...");
            synchronized (WaitClassLockExample.class) {
                System.out.println("Thread 2: Acquired class lock.");
            }
        });

        thread1.start();
        thread2.start();

        // Unblock thread1 after some delay
        Thread.sleep(3000);
        synchronized (WaitClassLockExample.class) {
            System.out.println("Main thread: Notifying thread 1...");
            WaitClassLockExample.class.notify();
        }

        thread1.join();
        thread2.join();
    }
}

