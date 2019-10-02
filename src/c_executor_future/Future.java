package c_executor_future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by devesh on 30/07/19.
 */
public class Future {


    ExecutorService service = Executors.newFixedThreadPool(1);

    public void logic() throws InterruptedException, ExecutionException {
        java.util.concurrent.Future<String> submit = service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000);
                return "resutlto";
            }
        });

        while (!submit.isDone()){
            Thread.sleep(100);
            System.out.println("Waiting..");
        }

        String s = submit.get();
        System.out.println("result is "+ s);

    }

    public static void main(String ar[]) throws ExecutionException, InterruptedException {
        Future future = new Future();
        future.logic();
    }

}
