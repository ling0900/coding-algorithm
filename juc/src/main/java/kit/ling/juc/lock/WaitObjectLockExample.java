package kit.ling.juc.lock;

public class WaitObjectLockExample {

    private final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        WaitObjectLockExample example = new WaitObjectLockExample();
        example.testObjectLock();
    }

    public void testObjectLock() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Thread 1: Acquired object lock and calling wait...");
                    lock.wait();  // Releases object lock and waits
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

            System.out.println("Thread 2: Trying to acquire object lock...");
            synchronized (lock) {
                System.out.println("Thread 2: Acquired object lock.");
            }
        });

        thread1.start();
        thread2.start();

        // Unblock thread1 after some delay
        Thread.sleep(3000);
        synchronized (lock) {
            System.out.println("Main thread: Notifying thread 1...");
            lock.notify();
        }

        thread1.join();
        thread2.join();
    }
}

