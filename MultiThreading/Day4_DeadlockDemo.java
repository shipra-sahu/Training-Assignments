package ms.training;
class Class1 implements Runnable {
	 public Object lock1 = null;
	 public Object lock2 = null;
	 
	 public Class1(Object lock1,Object lock2) {
		 this.lock1=lock1;
		 this.lock2=lock2;
	 }
	    public void run() {
	       synchronized (lock1) {
	          System.out.println("Thread 1: Holding lock 1...");
	          
	          try { Thread.sleep(10); }
	          catch (InterruptedException e) {}
	          System.out.println("Thread 1: Waiting for lock 2...");
	          
	          synchronized (lock2) {
	             System.out.println("Thread 1: Holding lock 1 & 2...");
	          }
	       }
	    }
	 }

class Class2 implements Runnable {
		public Object lock1 = null;
		 public Object lock2 = null;
		 
		 public Class2(Object lock1,Object lock2) {
			 this.lock1=lock1;
			 this.lock2=lock2;
		 }
	    public void run() {
	       synchronized (lock2) {
	          System.out.println("Thread 2: Holding lock 2...");
	          
	          try { Thread.sleep(10); }
	          catch (InterruptedException e) {}
	          System.out.println("Thread 2: Waiting for lock 1...");
	          
	          synchronized (lock1) {
	             System.out.println("Thread 2: Holding lock 1 & 2...");
	          }
	       }
	    }
	 }

public class Day4_DeadlockDemo {
	
	 public static void main(String[] args) {
		 Object lock1 = new Object();
		 Object lock2 = new Object();
		 new Thread(new Class1(lock1,lock2)).start();
		 new Thread(new Class2(lock1,lock2)).start();

	}
	
}
