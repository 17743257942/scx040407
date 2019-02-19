package com.scx040407.untitled.practice.InnerClassTest.localinner;
/*
LocalCounter()
Counter()
local inner 0
local inner 1
local inner 2
local inner 3
local inner 4
anonymous inner  5
anonymous inner  6
anonymous inner  7
anonymous inner  8
anonymous inner  9
 */
public class LocalInnerClass {
    private int count = 0;

    Counter getCounter(final String name) {
        class LocalCounter implements Counter {
            public LocalCounter() {
                System.out.println("LocalCounter()");
            }
            @Override
            public int next() {
                System.out.print(name);
                return count++;
            }
        }
        return new LocalCounter();
    }

    Counter getCounter2(final String name) {
        return new Counter() {
            // 初始化代码块，创建对象的时候就运行了
            {
                System.out.println("Counter()");
            }

            @Override
            public int next() {
                System.out.print(name);
                return count++;
            }
        };
    }

    public static void main(String[] args) {
        LocalInnerClass lic = new LocalInnerClass();
        Counter c1 = lic.getCounter("local inner ");
        Counter c2 = lic.getCounter2("anonymous inner  ");
        for (int i = 0; i < 5; i++) {
            System.out.println(c1.next());
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(c2.next());
        }
    }


}
