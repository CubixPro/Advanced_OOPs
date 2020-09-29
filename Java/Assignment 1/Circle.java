import java.util.*;

class Circle
{
	static double PI= 3.14;
	
	public static void main(String args[])
	{
		Scanner s= new Scanner(System.in);
		System.out.println("Enter radius: ");
		double r= s.nextInt();
		double a= r*r*Circle.PI;
		System.out.println("Area: "+a);
	}
}