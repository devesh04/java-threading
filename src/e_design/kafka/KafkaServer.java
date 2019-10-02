package e_design.kafka;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by devesh on 01/11/18.
 */
public class KafkaServer {

    Set<Topic> topics;
    private static KafkaServer server;

    Map<Topic, ConcurrentLinkedQueue<Object>> data = new ConcurrentHashMap<>();


    public void addNewTopic(Topic topic){
        if(this.topics == null){
            this.topics = new HashSet<>();
        }
        this.topics.add(topic);
    }

    public void produceMessage(Topic topic, Object object){
        if(data.containsKey(topic)){
            data.get(topic).add(object);
        }
        else{
            addNewTopic(topic);
            ConcurrentLinkedQueue<Object> list = new ConcurrentLinkedQueue<>();
            list.add(object);
            data.put(topic, list);
        }
    }


    public Object consumeMessage(Topic topic){
        if(data.containsKey(topic)){
            Object o = data.get(topic).poll();
//            data.get(topic).remove(0);
            return o;
        }
        return null;
    }

    private KafkaServer(){

    }

    public static KafkaServer getInstance(){
        if(server == null){
            server = new KafkaServer();
        }
        return server;
    }



}
