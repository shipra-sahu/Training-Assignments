package ms.training;

class PrintA implements Runnable{
	
	Object locker=null;
	public PrintA(Object x) {
		this.locker=x;
	}
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			synchronized (locker) {
				System.out.println("A");
				locker.notify();
				try {
					locker.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}
}
 
class PrintB implements Runnable{

	Object locker=null;
	public PrintB(Object x) {
		this.locker=x;
	}
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			synchronized (locker) {
				System.out.println("B");
				locker.notify();
				try {
					locker.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
}
}

public class Day4_SwitchingThread {
	public static void main(String[]args) {
		Object lock= new Object();
		PrintA a= new PrintA(lock);
		PrintB b= new PrintB(lock);
		new Thread(a).start();
		new Thread(b).start();
	}

		
}

