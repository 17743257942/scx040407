package com.scx040407.untitled.bigdata.it18zhang.thread.prodconsumer.deadlock;

class DeadLockApp{
	public static void main(String[] args){
		//ʹ��java�м����࣬List���б���
		Pool pool = new Pool();
		
		Productor p1 = new Productor("������1",pool);
		p1.setName("p1");
		
		Consumer c1 = new Consumer("������",pool);
		c1.setName("c1");
		Consumer c2 = new Consumer("������",pool);
		c2.setName("c2");
		
		p1.start();
		c1.start();
		c2.start();
	}
}
//������
class Productor extends Thread{
	static int i = 0 ;
	private String name ;
	private Pool pool ;
	public Productor(String name ,Pool pool){
		this.name = name ;
		this.pool = pool ;
	}
	public void run(){
		while(true){
			pool.add(i ++);
		}
	}
}
//������
class Consumer extends Thread{
	private String name ;
	private Pool pool ;
	public Consumer(String name ,Pool pool){
		this.name = name ;
		this.pool = pool;
	}
	public void run(){
		while(true){
			pool.remove();
			//System.out.println("-: " + i);
		}
	}
}

class Pool{
	private java.util.List<Integer> list = new java.util.ArrayList<Integer>();
	//�������ֵ
	private int MAX = 1 ;
	//����Ԫ��
	public void add(int n){
		synchronized(this){
			try{
				String name = Thread.currentThread().getName();
				while(list.size() == MAX){
					System.out.println(name + ".wait()");
					this.wait(1000);
				}
				list.add(n);
				System.out.println(name + " + : " + n);
				System.out.println(name + ".notify()");
				this.notify();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	//ɾ��Ԫ��
	public int remove(){
		synchronized(this){
			try{
				String name = Thread.currentThread().getName();
				while(list.size() == 0){
					System.out.println(name + ".wait()");
					this.wait(1000);
				}
				int i = list.remove(0);
				System.out.println(name + " - : "  + i);
				System.out.println(name + ".notify()");
				this.notify();
				return i ;
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return -1 ;
		}
	}
}
