package first;

class Q{
	int n;
	boolean valueSet = false;
	synchronized int get() {
		while(!valueSet) 
			try {
				wait();
			}catch(InterruptedException e) {
				System.out.println("Error");
				e.printStackTrace();
			}
			System.out.println("Got :" + " " + n);
			valueSet = true;
			notify();
			return n;
	}
	
	synchronized void put(int n) {
		while(valueSet) {
			try {
				wait();
			}catch(InterruptedException e) {
				System.out.println("Error");
				e.printStackTrace();
			}
			this.n = n;
			valueSet = false;
			System.out.println("Put :" + " " + n);
			notify();
		}
	}
}

class Producer implements Runnable{
	Q q;
	Producer(Q q){
		this.q = q;
		new Thread(this, "Producer").start();
	}
	
	public void run() {
		int i=0;
		while(true) {
			q.put(i++);
			try {Thread.sleep(1000);} catch(Exception e) {}
		}
	}
}

class Consumer implements Runnable{
	Q q;
	Consumer(Q q){
		this.q = q;
		new Thread(this, "Consumer").start();
	}
	
	public void run() {
		while(true) {
			q.get();
			try {Thread.sleep(2000);} catch(Exception e) {}
		}
	}
}

class Prod_cons {
public static void main(String args[]) {
	Q q = new Q();
	new Producer(q);
	new Consumer(q);
	System.out.println("Press enter to end");
}
}
