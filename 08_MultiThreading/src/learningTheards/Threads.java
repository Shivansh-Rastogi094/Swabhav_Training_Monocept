package learningTheards;

public class Threads {

    public static void main(String[] args) {

        System.out.println("Main thread: " + Thread.currentThread().getName());

        // Thread 1
        Thread t1 = new Thread(() -> {
            System.out.println("Started: " + Thread.currentThread().getName());

            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + " - Count: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted!");
                }
            }

            System.out.println("Finished: " + Thread.currentThread().getName());
        }, "Worker-1");

        // Thread 2
        Thread t2 = new Thread(() -> {
            System.out.println("Started: " + Thread.currentThread().getName());

            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + " - Count: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted!");
                }
            }

            System.out.println("Finished: " + Thread.currentThread().getName());
        }, "Worker-2");

        // Start threads
        t1.start();
        t2.start();

        // Wait for both threads
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread finished");
    }
}