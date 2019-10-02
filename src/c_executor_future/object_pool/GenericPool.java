package c_executor_future.object_pool;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by devesh on 06/05/19.
 */
public abstract class GenericPool<T> {

    ConcurrentLinkedQueue<T> queue;
    ScheduledExecutorService executorService;

    public abstract T createResource();

    public GenericPool(final int min, final int max, int interval, TimeUnit intervalUnit){
        init(min);
        this.executorService = Executors.newSingleThreadScheduledExecutor();
        this.executorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println("size:" + queue.size());
                while (queue.size() < min){
                    T resource = createResource();
                    System.out.println("self adding " + resource.toString());
                    queue.add(resource);
                }
                while (queue.size() > max){
                    System.out.println("Self eliminating");
                    T poll = queue.poll();
                    System.out.println("Self eliminating " + poll);
                }
            }
        }, interval, interval, intervalUnit);
    }

    private void init(int min){
        this.queue = new ConcurrentLinkedQueue<>();
        for(int i = 0; i < min; i++){
            this.queue.add(createResource());
        }
    }

    public void shutdown(){
        if(this.executorService != null)
            this.executorService.shutdown();
    }

    public T borrow(){
        T resource;
        if((resource = this.queue.poll()) == null){
            System.out.println("creating new resource");
            resource = createResource();
        }
        System.out.println("borrowing "+ resource.toString());
        return resource;
    }

    public void returno(T resource){
        if(resource != null){
            System.out.println("returning "+ resource.toString());
            this.queue.offer(resource);
        }
    }


}
