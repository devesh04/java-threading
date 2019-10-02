package b_thread_concepts;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by devesh on 30/07/19.
 */
public class MultithreadingABC {

    AtomicInteger monitor = new AtomicInteger(1);

    class T1 implements Runnable {

        @Override
        public void run() {
            try{
                while (true){
                    synchronized (monitor){
                        if(monitor.get() == 1){
                            System.out.println("A");
                            Thread.sleep(1000);
                            monitor.incrementAndGet();
                            monitor.notifyAll();
                        }
                        else{
                            monitor.wait();
                        }
                    }
                }
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    class T2 implements Runnable {

        @Override
        public void run() {
            try{
                while (true){
                    synchronized (monitor){
                        if(monitor.get() == 2){
                            System.out.println("B");
                            Thread.sleep(1000);
                            monitor.incrementAndGet();
                            monitor.notifyAll();
                        }
                        else{
                            monitor.wait();
                        }
                    }
                }
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    class T3 implements Runnable {

        @Override
        public void run() {
            try{
                while (true){
                    synchronized (monitor){
                        if(monitor.get() == 3){
                            System.out.println("C");
                            Thread.sleep(1000);
                            monitor.set(1);
                            monitor.notifyAll();
                        }
                        else{
                            monitor.wait();
                        }
                    }
                }
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String ar[]){
        MultithreadingABC multithreading = new MultithreadingABC();
        T1 t1 = multithreading.new T1();
        T2 t2 = multithreading.new T2();
        T3 t3 = multithreading.new T3();

        new Thread(t3).start();
        new Thread(t1).start();
        new Thread(t2).start();



    }

}
