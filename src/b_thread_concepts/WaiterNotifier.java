package b_thread_concepts;

public class WaiterNotifier implements Runnable {

	Object objectMonitor;
	boolean isWaiter;

	public WaiterNotifier(Object mo, boolean isWaiter){
		this.objectMonitor = mo;
		this.isWaiter = isWaiter;
	}

	public void waiter() throws InterruptedException {

		synchronized (this.objectMonitor){
			objectMonitor.wait();
			System.out.println("wait time over, let's do stuff");
		}
	}

	public void notifier() throws InterruptedException {
		synchronized (this.objectMonitor){
			Thread.sleep(1000);
			objectMonitor.notify();
			System.out.println("Notified");
		}
	}

	@Override
	public void run() {
		if(isWaiter){
			try {
				waiter();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		else{
			try {
				notifier();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String ar[]) throws InterruptedException {

		Object objectMonitor = new Object();

		WaiterNotifier thread1= new WaiterNotifier(objectMonitor, true);
		WaiterNotifier thread2 = new WaiterNotifier(objectMonitor, false);

		Thread thread = new Thread(thread1, "ww");
		thread.start();

		Thread thread3 = new Thread(thread2, "nn");
		thread3.start();

	}


}