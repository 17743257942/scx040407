package com.scx040407.untitled.bigdata.Threadlxx02;

/**
 * Saler
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
		}
	}
}
 