package e_design.kafka;

/**
 * Created by devesh on 01/11/18.
 */
public class Run {

    public static void main(String args[]) throws InterruptedException {

        Topic foodOrder = new Topic("foodOrder");
        Topic clothOrder = new Topic("clothOrder");


        Consumer consumer = new Consumer(foodOrder);
        Consumer consumer1 = new Consumer(clothOrder);

        Producer producer = new Producer(foodOrder);
        Producer producer1 = new Producer(clothOrder);

        String [] food = {"paneer", "aaloo", "ghobi", "tamatoar" };
        String [] cloth = {"jeans", "shirt", "pant", "jacket" };

        int i = 0;
        int j = 0;
        while (true){
            if(((int)(Math.random()* 100))%2 == 0){
                producer.produceMessage(food[i]);
                i = (i + 1)%4;
            }
            else{
                producer1.produceMessage(cloth[j]);
                j = (j + 1)%4;
            }
            Thread.sleep(800);
        }


    }
}
