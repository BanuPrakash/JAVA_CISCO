public class UncheckedExample1 {
    public static void main(String[] args) {
        System.out.println("main called!!!");
        doTask();
        System.out.println("Main Ends");
    }

    private static void doTask() {
        int x = 10;
        int y = 0;
        int res = x / y;
        System.out.println("Result " + res);
    }
}
