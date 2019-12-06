package HelloWorld;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class HelloWorld {
    private int n;
    private static Lock lock = new ReentrantLock();
    private int count = 0;
    
    public HelloWorld( int n){
        this.n = n;
    }
    public void hello() throws InterruptedException{	
        for (int i = 0; i < n;) {
        	lock.lock();
        	if(count%2==0) {
        		System.out.print("Hello");
        		count++;
        		i++;
        	}
            lock.unlock();
        }
    }

    public void world() throws InterruptedException{
    	for (int i = 0; i < n;) {
        	lock.lock();
        	if(count%2==1) {
        		System.out.println("World!");
        		count++;
        		i++;
        	}
            lock.unlock();
        }
    }
}
