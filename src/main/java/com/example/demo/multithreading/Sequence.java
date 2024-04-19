package com.example.demo.multithreading;

public class Sequence implements Runnable{

    static Integer size=10;
    static Integer number=0;

    int rem;

    public Sequence(int rem) {
        this.rem = rem;
    }

   static  Object lock=new Object();

    @Override
    public void run() {
        while (number<size){
            synchronized (lock){
                while(number%3 !=rem){
                    try{
                        lock.wait();
                    }
                    catch (InterruptedException ex){
                        ex.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " " + number);
                number++;
                lock.notifyAll();
            }
        }
    }

    public static void main(String[] args)throws Exception{
        int x=-4;
        int y=4;
        System.out.println(x>>1);
        System.out.println(y>>2);
    }
}
