package ms.training;

import java.util.ArrayList;
import java.util.List;

class Producer implements Runnable{
	List<Integer> bucket =null;
	int size = 20;
	int counter = 0;
	public Producer(List<Integer> bucket) {
		this.bucket = bucket;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
			while(true) {
				synchronized (bucket) {
					while(bucket.size()==size) {
						try {
							bucket.notify();
							bucket.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					  System.out.println("Producer produced-" + counter); 

					bucket.add(counter++); 
					bucket.notify(); 
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
//				bucket.add(counter++);
//				Thread.currentThread().notify();
			}
		
	}
	
}

class Consumer implements Runnable{

	List<Integer> bucket =null;
	public Consumer(List<Integer> bucket) {
		this.bucket = bucket;
	}
	@Override
	public void run() {
		
		while(true) {
			synchronized(bucket) {
				while(bucket.isEmpty()) {
					try { 
						bucket.notify();
						bucket.wait(); }
			          catch (InterruptedException e) {}
				}
				System.out.println(bucket.remove(bucket.size()-1)+" is Consumed..");	
				bucket.notify();
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		
	} 
	}
	
}
public class Day4_ProducerConsumerDemo {

	public static void main(String[] args) {
		List<Integer> bucket =  new ArrayList<Integer>();
		Thread t1=new Thread(new Producer(bucket));
		Thread t2=new Thread(new Consumer(bucket));
		t1.start();
		t2.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		

	}

}
