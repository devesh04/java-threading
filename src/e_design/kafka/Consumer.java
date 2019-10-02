package e_design.kafka;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by devesh on 01/11/18.
 */
public class Consumer {

    Topic topic;
    ScheduledExecutorService executor;

    public Consumer(final Topic topic){
        this.topic = topic;
        this.executor = Executors.newSingleThreadScheduledExecutor();
        this.executor.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                Object o = KafkaServer.getInstance().consumeMessage(topic);
                if(o != null)
                System.out.println("Consumed message - " + o + " on topic - " + topic);
            }
        }, 0, 1, TimeUnit.SECONDS);
    }


}
