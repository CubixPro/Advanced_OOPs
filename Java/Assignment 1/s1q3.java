import java.util.Scanner;
class s1q3
{
    public static void main(String args[])
    {
        System.out.println("Enter your height in cm: ");
        Scanner ip = new Scanner(System.in);
        int cm = ip.nextInt();
        int feet = (int)(cm/30.5);
        double d = cm - (30.5)*feet;
        d = d/2.54;
        System.out.println("Your height is: "+ feet +" feet " + d +" inches (apprx)");
    }
}