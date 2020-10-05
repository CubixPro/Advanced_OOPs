import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;

public class Prog3_4 {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            String filename;

            System.out.print("Enter a filename: ");
            filename = in.nextLine();

            File obj = new File(filename);
            if(!obj.createNewFile()) {
                System.out.println("File already exists!!\n");
            }

            String choice , name;
            FileWriter writer = new FileWriter(filename);
            do {
                System.out.print("Enter name : ");
                name = in.nextLine();
                writer.write(name);
                writer.write("\n");
                System.out.print("Want to write more ? (yes/no) : ");
                choice = in.nextLine();
            }while(choice.equals("yes"));
            writer.close();
            
            Scanner reader = new Scanner(obj);
            System.out.println("File Contents : ");
            while(reader.hasNextLine()) {
                name = reader.nextLine();
                System.out.println(name);
            }
            reader.close();           
        }
        catch(IOException e) {
            System.out.println("Error!!");
            e.printStackTrace();
        }
    }
}
