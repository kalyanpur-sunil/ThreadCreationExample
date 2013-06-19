package org.sunil.thread;

//One way of creating a Thread by extending Thread class and overriding 
//run() method
class AppThread extends Thread{

	@Override
	public void run(){
		for(int i=1;i<=10;i++){
			System.out.println(Thread.currentThread().getName()+": "+ i);
		}

		//will make my thread sleep for 1000ms
		try{
			Thread.sleep(1000);
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}
	}
}

//second way of creating a Thread is by making class to implement Runnable 
//method

class AppRunnable implements Runnable{
	@Override
	public void run(){
		for(int i=1;i<=10;i++){
			System.out.println(Thread.currentThread().getName()+": "+ i);
		}

		//will make my thread sleep for 1000ms
		try{
			Thread.sleep(1000);
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}
	}
}

public class Application1 {

	public static void main(String[] args) {
		//create an instance of Thread 
		AppThread thread1 = new AppThread();
		thread1.setName("Thread-1");
		//To start a thread it is always necessary to call start() method.
		//else thread will run in the main thread and we wont be creating 
		//separate thread of execution. Calling start() method will create 
		//a separate thread
		thread1.start();
		
		//create another thread
		AppThread thread2 = new AppThread();
		
		thread2.setName("Thread-2");
		thread2.start();
		
		try {
			//Waits for this thread 1 & 2 to die.
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("*CREATING THREAD THAT IMPLEMENTS RUNNABLE*");
		//RunnableThread-3 is the name of Runnable thread I am creating below
		Thread thread3 = new Thread(new AppRunnable(), "RunnableThread-3");
		thread3.start();
		
	}

}
