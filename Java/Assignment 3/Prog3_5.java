import java.util.*;
import java.io.*;

class Student implements Serializable {
    int roll;
    String name;
    float score;

    public Student() {}

    public Student(int roll , String name , float score) {
        this.roll = roll;
        this.name = name;
        this.score = score;
    }

    public void getData() {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter Name: ");
        name = in.nextLine();
        System.out.print("Enter Roll: ");
        roll = Integer.parseInt(in.nextLine());
        System.out.print("Enter Score: ");
        score = Float.parseFloat(in.nextLine());
    }

    @Override
    public String toString() {
        return "\nName: " + name + "\nRoll: " + roll + "\nScore: " + score;
    }
}

public class Prog3_5 {
    public static void main(String[] args) {
        try {
            String filename;
            Scanner in = new Scanner(System.in);

            System.out.print("Enter filename: ");
            filename = in.nextLine();
            
            FileOutputStream f = new FileOutputStream(new File(filename));
            ObjectOutputStream o = new ObjectOutputStream(f);

            String choice;
            do {
                Student obj = new Student();
                obj.getData();  
                o.writeObject(obj);
                System.out.println("\nWant to write more entries: (yes/no)? ");
                choice = in.nextLine();
            }while(choice.equals("yes"));
            o.close();
            f.close();

            FileInputStream fi = new FileInputStream(new File(filename));
            ObjectInputStream oi = new ObjectInputStream(fi);

            Student obj = new Student();
            System.out.println("File Contents : ");
            while(true) {
                try {
                    obj = null;
                    obj = (Student)oi.readObject();
                    if(obj != null) {
                        System.out.println(obj);
                    }
                }
                catch(EOFException e) {
                    oi.close();
                    fi.close();
                    break;
                }
            }
        }
        catch(Exception e) {
            System.out.println("Error!!");
            e.printStackTrace();
        }
    }
}