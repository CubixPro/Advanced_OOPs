import java.util.Scanner;

public class s2q6
{
	public static void main(String args[])
	{
		//basic type to wrapper
		int a = 5;
		Integer iobj = new Integer(a);
		
		//object to basic type
		Integer iobj2 = new Integer(4);
		int p;
		p = iobj2.intValue();
		
		//basic to String type
		int a2 = 10;
		String s = Integer.toString(a2);
		
		//string to numeric obj
		String mama = new String("1122334");
		int a3 = Integer.parseInt(mama);
		
		//string to wrapper class
		Integer iobj1 = Integer.valueOf("5678");
	} 
}
