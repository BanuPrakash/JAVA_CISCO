public class ThreadClient {
    public static void main(String[] args) {
        System.out.println("Main Thread starts  " + Thread.currentThread());
            scheduleThreads();
        System.out.println("Main Thread dies ");
    }

    private static void scheduleThreads() {
        NumberThread t1 = new NumberThread(800, 1200); // new state
        NumberThread t2 = new NumberThread(1, 120); // new state
        NumberThread t3 = new NumberThread(400, 500); // new state, No stack for any of the 3 threads

        t1.setDaemon(true); // Process doesn't wait for this thread to finish

        t1.start(); // calls start0() --> allocate Stack and place run() on the stack, main and t1 are runnable
        t2.start(); // t1, t2 and main are runnable
        t3.start(); // t1, t2, t3 and main are runnable

    }
}
