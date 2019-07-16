package com.scx040407.untitled.bigdata.Threadlxx02;

import java.util.LinkedList;

/**
 * Æ±³Ø
 */
public class TicketPool {
	
	private LinkedList<Integer> pool = new LinkedList<Integer>();
	
	public /*synchronized*/ int add(Integer i){
		pool.add(i);
		return i ;
	}
	
	public /*synchronized*/ int remove(){
		try {
			while(pool.isEmpty()){
				Thread.sleep(50);
			}
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pool.removeFirst();
	}
}


