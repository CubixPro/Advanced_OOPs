import java.io.File;
import java.util.Scanner;

public class Prog3_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String filename;

        System.out.println("Enter any Filename : ");
        filename = in.nextLine();

        File f = new File(filename);
        if(f.exists()) {
            if(f.isDirectory()) {
                File[] list = f.listFiles();
                
                for(int i = 0; i < list.length; i++) {
                    System.out.println(list[i].getName());
                }
            }
            else {
                if(f.canRead()) {
                    System.out.println("File is readable!!");
                }
                else {
                    System.out.println("File is not readable!!");
                }

                if(f.canWrite()) {
                    System.out.println("File is writable!!");
                }
                else {
                    System.out.println("File is not writable!!");
                }
            }
        }
        else {
            System.out.println("File doesnot exist!!");
        }
    }
}