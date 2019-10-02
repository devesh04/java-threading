package a_creation;

public class ByThread {

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("This is my runnable thread " + Thread.currentThread().getId());
        }
    }

    public static void main(String ar[]){
        System.out.println("Initiating few my threads in main thread");

        for(int i = 0; i < 5; i++){
            MyRunnable myRunnable = new MyRunnable();
            Thread thread = new Thread(myRunnable);
            thread.start();
        }

        System.out.println("Done running all threads");

    }
}
