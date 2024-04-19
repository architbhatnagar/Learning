public class Main {

    public static void main(String[] args) {

    }


}

class Sequence implements Runnable{
    public static int size=10;
    public static int n=1;

    int rem;

    public Sequence(int rem){
        this.rem=rem;
    }

    static Object lock=new Object();
    @Override
    public void run() {
        while(n<size){
            synchronized (lock){
                try {
                    while (size % n != rem) {
                        lock.wait();
                    }
                }
                catch (InterruptedException e){

                }
                n++;
                System.out.println(Thread.currentThread().getName()+"--"+n);
                lock.notifyAll();
            }
        }
    }
}







