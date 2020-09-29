import java.util.*;

class Sum
{
	public static void main(String args[])
	{
		Scanner s= new Scanner(System.in);
		System.out.println("Enter 2 short integers: ");
		short n= s.nextShort();
		short m= s.nextShort();
		int ans= n+m;
		System.out.println("Sum= "+ans);
	}
}
