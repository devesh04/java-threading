package d_leetcode;
import java.util.concurrent.atomic.AtomicInteger;

/*
     https://leetcode.com/problems/print-in-order/
 */

class PrintAllInOrder {

    private AtomicInteger ai = new AtomicInteger(1);

    public PrintAllInOrder() {

    }
    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        while(true){
            synchronized(ai) {
                if(ai.get() == 1){
                    printFirst.run();
                    ai.set(2);
                    ai.notifyAll();
                    break;
                }
                else{
                    ai.wait();
                }
            }
        }


    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        while(true){
            synchronized(ai){
                if(ai.get() == 2){
                    printSecond.run();
                    ai.set(3);
                    ai.notifyAll();
                    break;
                }
                else{
                    ai.wait();
                }
            }
        }


    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        while(true){
            synchronized(ai){
                if(ai.get() == 3){
                    printThird.run();
                    ai.set(1);
                    ai.notifyAll();
                    break;
                }
                else{
                    ai.wait();
                }
            }
        }
    }
}