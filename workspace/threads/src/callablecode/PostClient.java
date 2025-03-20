package callablecode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PostClient {
    public static void main(String[] args) throws  Exception{
        ExecutorService service = Executors.newFixedThreadPool(3);

        Future<String> postFuture = service.submit(new PostService()); // concurrently
        Future<String> userFuture = service.submit(new UserService()); // concurrently

        // get posts and users --> format and print in the client
        System.out.println(userFuture.get());
        System.out.println(postFuture.get());

        service.shutdown();
    }
}
