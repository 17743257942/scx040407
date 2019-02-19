package com.scx040407.untitled.bigdata.it18zhang.thread.prodconsumer;

import java.util.LinkedList;

/**
 * Æ±³Ø
 */
public class TicketPool {
	
	private LinkedList<Integer> pool = new LinkedList<Integer>();
	
	private int MAX = 100 ;
	
	public synchronized int add(Integer i){
		while(pool.size() >= MAX){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//
		pool.add(i);
		notify();
		return i ;
	}
	
	public synchronized int remove(){
		while(pool.isEmpty()){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		int n = pool.removeFirst();
		notify();
		return n;
	}
}


