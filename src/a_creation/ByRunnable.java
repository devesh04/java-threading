package a_creation;

public class ByRunnable {

    static class MyThread extends Thread {
        public void run(){
            System.out.println("Running my thread " + this.getId());
        }
    }

    public static void main(String ar[]){
        System.out.println("Initiating few my threads in main thread");

        for(int i = 0; i < 5; i++){
            MyThread myThread = new MyThread();
            myThread.start();
        }

        System.out.println("Done running all threads");

    }
}
