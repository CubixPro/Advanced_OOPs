class Var {
    int n;

    public Var() {
        n = 0;
    }

    public synchronized void inc(int delta) {
        n += delta;
        System.out.println("Value after increment : " + n);
    }

    public synchronized void dec(int delta) {
        n -= delta;
        System.out.println("Value after decrement : " + n);
    }
}

class IncThread implements Runnable{
    Var v;
    Thread t;

    public IncThread(Var v , String threadName) {
        this.v = v;
        t = new Thread(this , threadName);
    }

    public void run() {
        v.inc(1);
    }
}

class DecThread implements Runnable{
    Var v;
    Thread t;

    public DecThread(Var v , String threadName) {
        this.v = v;
        t = new Thread(this , threadName);
    }

    public void run() {
        v.dec(1);
    }
}

public class Prog4_2 {
    public static void main(String[] args) {
        Var v = new Var();
        IncThread i1 = new IncThread(v , "incThread1");
        IncThread i2 = new IncThread(v , "incThread2");
        DecThread d1 = new DecThread(v , "decThread1");
        DecThread d2 = new DecThread(v , "decThread2");

        i1.t.start();
        i2.t.start();
        d1.t.start();
        d2.t.start();

        try {
            i1.t.join();
            i2.t.join();
            d1.t.join();
            d2.t.join();
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Value after all threads finished : " + v.n);
    }
}