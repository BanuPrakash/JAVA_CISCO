package callablecode;

import java.util.concurrent.Callable;

// instead of Runnable, use Callable
public class NumberThread implements Callable<Integer> {
    // instead of run()
    int start;
    int end;

    public NumberThread(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() throws Exception {
        int total = 0;
        for (int i = start; i <= end ; i++) {
            total += i;
        }
        return total;
    }
}
