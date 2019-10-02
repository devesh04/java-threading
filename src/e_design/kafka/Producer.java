package e_design.kafka;

/**
 * Created by devesh on 01/11/18.
 */
public class Producer {

    Topic topic;

    public Producer(Topic topic){
        this.topic = topic;
    }

    public void produceMessage(Object o){
        KafkaServer.getInstance().produceMessage(topic, o);
    }

}
