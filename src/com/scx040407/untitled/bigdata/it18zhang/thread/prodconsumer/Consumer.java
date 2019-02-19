package com.scx040407.untitled.bigdata.it18zhang.thread.prodconsumer;

/**
 * Consumer
 */
public class Consumer extends Thread {
	private String name ;
	
	private TicketPool pool ;
	
	public Consumer(String name,TicketPool pool) {
		super();
		this.name = name;
		this.pool = pool ;
	}

	public void run() {
		while(true){
			int n = pool.remove();
			System.out.println(name + " remove : " + n);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
 