import java.util.*;

class Prog1_6
{
	static void show(int i)
	{
		System.out.println("Inside show function");
	}
	
	static void show(double d)
	{
		System.out.println("Inside show function");
	}
	
	public static void main(String args[])
	{
		short s=5;
		show(s);
		double d= 5.56;
		show(d);  
	}
}