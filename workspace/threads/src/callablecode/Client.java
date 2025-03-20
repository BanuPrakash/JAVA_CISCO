package callablecode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws Exception {
        // thread pool of size 3
        ExecutorService service = Executors.newFixedThreadPool(3);

        Future<Integer> f1 = service.submit(new NumberThread(1, 100));
        Future<Integer> f2 = service.submit(new NumberThread(100, 800));

        System.out.println(f1.get()); // blocking
        System.out.println(f2.get()); // blocking

        service.shutdown();
    }
}
