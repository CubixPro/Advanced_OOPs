import java.io.*;
import java.util.*;

class FileCreate
{
    public static void main(String args[]) throws IOException
    {
        //FileWriter fw = new FileWriter();
        File obj = new File("Random.txt");
        try
        {
            if(obj.createNewFile()) 
            {
                System.out.println("File created: " + obj.getName());
            }
            else
            {
                System.out.println("File already exists...!!! no problem!!");
            }
        }
        catch(IOException e)
        {
            System.out.println("An error occured!!");
            e.printStackTrace();
        }
        try
        {
            FileWriter fobj = new FileWriter("Random.txt",true);
            System.out.println("Enter the number of strings: ");
            int a;
            Scanner ip = new Scanner(System.in);
            a = ip.nextInt();
            for(int i = 0; i <a;i++)
            {
                System.out.println("Enter a name: ");
                Scanner ip1 = new Scanner(System.in);
                String s = ip1.nextLine();
                fobj.write(s+"\n");            
            }
            fobj.close();
            System.out.println("File write successfully\n");
        }
        
        catch(Exception e)
        {
            System.out.println("Error occured while writing!!");
            e.printStackTrace();
        }
            
        try
        {
            Scanner readObj = new Scanner(obj);
            System.out.println("The names you entered were: ");
            while(readObj.hasNextLine())
            Scanner ip = new Scanner(System.in);
            a = ip.nextInt();
            {
                String data = readObj.nextLine();
                System.out.println(data);
            }
            readObj.close();
            System.out.println("File read and closed successfully!!");
        }
        catch(Exception e)
        {
            System.out.println("Error occured while reading!!");
            e.printStackTrace();
        }
        
    }
}