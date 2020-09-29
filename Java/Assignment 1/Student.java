import java.util.*;

class Stu
{
	int roll;
	String name;
	double score;
	
	public void set(int r, String n, double s)
	{
		roll=r;
		n=name;
		s=score;
	}
	
	public void display()
	{
		System.out.println("Roll: "+roll);
		System.out.println("Name: "+name);
		System.out.println("Score: "+score);
	}
	
	public void copy(Stu s)
	{
		roll= s.roll;
		name= s.name;
		score= s.score;
	}
}

class StuMain
{
	public static void main(String args[])
	{
		Stu s1,s2;
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter student details: ");
		System.out.println("Enter roll: ");
		int r=sc.nextInt();
		System.out.println("Enter name: ");
		String n=sc.next();
		System.out.println("Enter score: ");
		double s= sc.nextDouble();
		s1.set(r, n, s);
		System.out.println("Details of the student: ");
		s1.show();
		s2.copy(s1);
		System.out.println("Details of the copied student: ");
		s2.show();
	}
}