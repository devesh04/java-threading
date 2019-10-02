package c_executor_future.object_pool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by devesh on 06/05/19.
 */
public class Liqour {
    String name;

    static List<String>  list = new ArrayList<>();

    static {
        list.add("beer");
        list.add("whisky");
        list.add("rum");
        list.add("breezer");
        list.add("gin");
        list.add("wine");
    }

    public Liqour(){
        Random rand = new Random();
        this.name = list.get(rand.nextInt(list.size()));
    }

    public String toString(){
        return this.name;
    }
}
