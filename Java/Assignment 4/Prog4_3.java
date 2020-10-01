import java.util.Scanner;

class Var {
    int activeReaders;
    int val;

    public Var() {
        activeReaders = 0;
        val = 0;
    }

    public void read(int num) {
        synchronized(this) {
            activeReaders++;
            System.out.println("Reader " + num + " starts reading.");
            System.out.println("Current Value : " + val);
        }
        
        try {
            Thread.sleep((int)(Math.random() * 5000));
        }
        catch(InterruptedException e) {}

        synchronized(this) {
            System.out.println("Reader " + num + " stops reading.");
            activeReaders--;
            if(activeReaders == 0) this.notifyAll();
        }
    }
    
    public synchronized void write(int num) {
        while(activeReaders != 0) {
            try {
                wait();
            } catch(InterruptedException e) {}
        }

        System.out.println("Writer " + num + " starts writing.");
        this.val = (int)(Math.random() * 5000);

        try {
            Thread.sleep((int)(Math.random() * 5000));
        } catch(InterruptedException e) {}

        System.out.println("Value after write : " + val);
        System.out.println("Writer " + num + " stops writing.");
    }
}

class Reader extends Thread {
    static int readers = 0;
    Var v;
    int num;

    public Reader(Var v) {
        this.v = v;
        num = Reader.readers++;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((int)(Math.random() * 5000));
        } catch(InterruptedException e) {}

        v.read(num);
    }
}

class Writer extends Thread {
    static int writers = 0;
    Var v;
    int num;

    public Writer(Var v) {
        this.v = v;
        num = Writer.writers++;
    }

    @Override
    public void run() {
        try{
            Thread.sleep((int)(Math.random() * 5000));
        } catch(InterruptedException e) {}
        
        v.write(num);
    }
}

public class Prog4_3 {
    public static void main(String[] args) {
        Var obj = new Var();
        int numOfWriters , numOfReaders;
        Scanner in = new Scanner(System.in);

        System.out.println("Enter num of Writers and Readers : ");
        numOfWriters = Integer.parseInt(in.nextLine());
        numOfReaders= Integer.parseInt(in.nextLine());

        for(int i = 0; i < numOfReaders; i++) {
            new Reader(obj).start();
        }

        for(int i = 0; i < numOfWriters; i++) {
            new Writer(obj).start();
        }
    }
}