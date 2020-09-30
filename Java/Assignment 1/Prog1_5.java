import java.util.*;

class Prog1_5
{
	public static void main(String args[])
	{
		String s;
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter a string: ");
		s= sc.next();
		String str;
		str= s;
		if(s==str)
			System.out.println("== comparison holds true");
		if(s.equals(str))
			System.out.println("equals function return true");
		System.out.println("Enter a string 2 times");
		s=sc.next();
		str=sc.next();
		if(s==str)
			System.out.println("== comparison holds true");
		if(s.equals(str))
			System.out.println("equals function return true");
	}
}