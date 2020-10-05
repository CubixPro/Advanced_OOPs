import java.util.Scanner;

class s1q4
{
    public static void main(String args[])
    {
        final static double pi = 3.14;
        System.out.print("Enter radius: ");
        int radius;
        Scanner ip = new Scanner(System.in);
        radius = ip.nextInt();
        double area = pi*radius*radius;
        System.out.println("area of the circle is: " + area);
    }
}