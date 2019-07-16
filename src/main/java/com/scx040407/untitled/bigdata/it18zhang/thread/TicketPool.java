package com.scx040407.untitled.bigdata.it18zhang.thread;

/**
 * Æ±³Ø
 */
public class TicketPool {
	
	private int tickNo = 100 ;
	
	/**
	 * 
	 */
	public synchronized int getTicket(){
		
		int tmp = tickNo;
		if(tmp == 0){
			return 0 ;
		}
		tickNo-- ;
		return tmp ;
	}
}


