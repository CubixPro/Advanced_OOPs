import java.util.Scanner;

class s1q1
{
    public static void main(String args[])
    {
        Scanner ip = new Scanner(System.in);
        short a,b;
        System.out.println("Enter 1st short number: ");
        a = ip.nextShort();
        System.out.println("Enter 2nd short number: ");
        b = ip.nextShort();
        int c = a+b;
        System.out.println("Answer: "+c);
    }
}