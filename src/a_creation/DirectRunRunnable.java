package a_creation;

import java.io.IOException;

public class DirectRunRunnable {

    public static class Runner implements Runnable{

        public void run() {
            System.out.println("bye from thread " +  Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws IOException {

        Runnable hello = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello from thread " + Thread.currentThread().getName());
            }
        };

        hello.run();
        hello = new Runner();
        hello.run();



    }
}
