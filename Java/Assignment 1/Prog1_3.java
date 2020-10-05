import java.util.*;

class Prog1_3
{
	public static void main(String args[])
	{
		Scanner s= new Scanner(System.in);
		System.out.println("Enter height: ");
		int n=s.nextInt();
		double f=(double)n/30.5;
		double d=n%30.5;
		double i=d/2.54;
		System.out.println("Foot: "+f+" Inches: "+i);
	}
}