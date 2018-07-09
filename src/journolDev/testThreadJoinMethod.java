package journolDev;
/*Java thread join method can be used to pause the current thread execution 
 * until unless the specified thread is dead. 
 * There are three overloaded join functions.
 * public final void join(): This java thread join method puts the current thread on wait 
 * 					until the thread on which it’s called is dead. If the thread is interrupted, 
 * 					it throws InterruptedException.

public final synchronized void join(long millis): This java thread join method is used to wait 
			for the thread on which it’s called to be dead or wait for specified milliseconds. 
			Since thread execution depends on OS implementation, 
			it doesn’t guarantee that the current thread will wait only for given time.

public final synchronized void join(long millis, int nanos): This java thread join method is 
			used to wait for thread to die for given milliseconds plus nanoseconds.

Here is a simple example showing usage of Thread join methods. 
The goal of the program is to make sure main is the last thread 
to finish and third thread starts only when first one is dead.


 */
public class testThreadJoinMethod {
public static void main(String[] args) {
	Thread t1=new Thread(new Threads(),"t1");
	Thread t2=new Thread(new Threads(),"t2");
	Thread t3=new Thread(new Threads(),"t3");
	
	t1.start();
	try {
		t3.join(4000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	t2.start();
	try {
		t3.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	t3.start();
	
	try {
		t1.join();
		t2.join();
		t3.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	System.out.println("All thread are dead now, Existing Main thread");
	
}
}

class Threads implements Runnable{

	public void run(){
		while(true){
		System.out.println("Thread started --"+Thread.currentThread().getName());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread Ended --"+Thread.currentThread().getName());
	}
}}