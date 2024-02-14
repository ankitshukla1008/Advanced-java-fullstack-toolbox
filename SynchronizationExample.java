// SynchronizationExample.java
class SynchronizationExample {

    // Shared resource
    private static int counter = 0;

    // Synchronized method to increment the counter
    private synchronized static void increment() {
        counter++;
    }

    public static void main(String[] args) {
        // Creating multiple threads
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                increment(); // Incrementing counter
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                increment(); // Incrementing counter
            }
        });

        // Starting the threads
        thread1.start();
        thread2.start();

        try {
            // Waiting for threads to finish
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Printing the final value of counter
        System.out.println("Final Counter Value: " + counter);
    }
}
 
/* Shared Resource (counter): The program has a shared integer variable named counter which is initially set to 0.

Synchronized Method (increment()): There's a synchronized method named increment() which increments the counter variable by 1. This method ensures that only one thread can execute it at a time, preventing race conditions.

Threads: Two threads (thread1 and thread2) are created. Both threads execute the run() method, which in turn calls the increment() method 1000 times each.

Thread Execution: Both threads execute concurrently, meaning they run at the same time. However, since the increment() method is synchronized, only one thread can execute it at a time. So, while one thread is executing increment(), the other thread has to wait.

Joining Threads: After starting both threads, the main thread calls join() on each of them. This makes the main thread wait until both thread1 and thread2 finish their execution.

Output: The program prints the final value of the counter variable after both threads finish execution. Since both threads increment the counter variable 1000 times each, the expected final value of counter should be 2000.

The output you will see is: 2000


If the increment() method is not synchronized, multiple threads can execute it simultaneously, leading to a race condition. In a race condition, the final value of the shared variable (counter in this case) can become unpredictable and may not be the expected sum of all increments performed by each thread.

Let's consider the scenario:private static void increment() {
                       counter++;
                }

Here, the increment() method is not synchronized, so multiple threads can execute it concurrently without any mutual exclusion.

When multiple threads access and modify the counter variable simultaneously, the following scenario can occur:

Thread A reads the value of counter.
Thread B reads the same value of counter.
Thread A increments the value of counter.
Thread B increments the same value of counter.
Both threads write their incremented values back to counter, effectively overwriting each other's changes.
This results in a loss of updates and the final value of counter being less than the sum of all increments performed by each thread.

The actual output in terms of the final value of counter will vary from run to run and depend on the interleaving of the thread execution. However, it is highly likely that the final value will be less than 2000 (the expected sum of increments performed by each thread), due to the race condition leading to lost updates.
*/
