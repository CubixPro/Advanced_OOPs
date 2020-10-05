class Id {
    int id = 0;

    synchronized int assignId() {
        id++;
        return id;
    }
}

class Value {
    int num = 0;
    int activeReaders = 0;
    boolean activeWriter = false;

    synchronized void decRead() {
        activeReaders--;
    }

    synchronized void incRead() {
        activeReaders++;
    }

   void activateWriter() {
        activeWriter = true;
    }

    void deactivateWriter() {
        activeWriter = false;
    }

    public void read(int id) {
        synchronized(this) {
            while(activeWriter == true) {
                try {
                    wait();
                } catch (InterruptedException e) {
    
                }
            }
        }
        
        incRead();
        System.out.println("Reader id :: " + id + " starts reading");
        System.out.println("Reader id :: " + id + " stops reading with num = " + num);
        decRead();
    }

    synchronized void write(int id) {
        while(activeReaders > 0) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }

        activateWriter();
        System.out.println("Writer id :: " + id + " starts writing");
        num++;
        System.out.println("Writer id :: " + id + " stops writing");  
        deactivateWriter();      
    }
}

class Reader extends Thread {
    Value n;
    Id id;

    public Reader(Value n, Id id) {
        this.n = n;
        this.id = id;
    }

    public void run() {
        while(true) {
            try {
                Thread.sleep((int)(Math.random()%5000 + 3000));
            } catch (InterruptedException e) {
    
            }
    
            n.read(id.assignId());
        }
    }
}

class Writer extends Thread {
    Value n;
    Id id;

    public Writer(Value n, Id id) {
        this.n = n;
        this.id = id;
    }

    public void run() {
        while(true) {
            try {
                Thread.sleep((int)(Math.random())%2000 + 1000);
            } catch (InterruptedException e) {
    
            }
    
            n.write(id.assignId());
        }
    }
}

public class Prog4_3 {
    public static void main(String args[]) {
        Value n = new Value();
        Id id = new Id();
        Reader reader1 = new Reader(n, id);
        Reader reader2 = new Reader(n, id);
        Writer writer1 = new Writer(n, id);
        Writer writer2 = new Writer(n, id);

       reader1.start();
       reader2.start();
       writer1.start();
       writer2.start();

       try {
        reader1.join();
        reader2.join();
        writer1.join();
        writer2.join();
       } catch(InterruptedException e) {

       }
    }
}
