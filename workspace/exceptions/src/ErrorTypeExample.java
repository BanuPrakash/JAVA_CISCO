public class ErrorTypeExample {
    public static void main(String[] args) {
        System.out.println("Main enters!!!");
        doTask();
    }

    private static void doTask() {
        System.out.println("Task Called!!!");
        doTask(); // recursive without exit condition
    }
}
