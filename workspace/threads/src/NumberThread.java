public class NumberThread extends Thread {
    private int begin;
    private int end;

    public NumberThread(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread() +  " starts !!!!");
        printNumbers();
        System.out.println(Thread.currentThread() + " ends !!!");
    }

    private void printNumbers() {
        for (int i = begin; i <= end; i++) {
            System.out.println(Thread.currentThread().getName()  + " : " + i);
        }
    }
}
