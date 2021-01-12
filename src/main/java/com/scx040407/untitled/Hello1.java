package com.scx040407.untitled;

public class Hello1 {
    private int count = 0;
    private double sum = 0.0D;

    public void submit(double value) {
        this.count++;
        sum += value;
    }

    public double getAvg() {
        if (0 == this.count) {
            return sum;
        }
        return this.sum / this.count;

    }


    public static void main(String[] args) {
        Hello1 hello1 = new Hello1();
        int num1=1;
        int num2=2;
        hello1.submit(num1);
        hello1.submit(num2);
        double avg = hello1.getAvg();


    }
}


