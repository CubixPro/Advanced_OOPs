import java.util.Scanner;

class Program{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String str = sc.nextLine();
		int cnt1=0,cnt2=0;
		int i;
		for(i=0;i<str.length();i++)
			if(str.charAt(i)=='a')
				cnt1++;
		System.out.println("No. of times 'a' appears is "+cnt1);
		for(i=0;i<str.length()-3;i++)
			if(str.substring(i,i+3).equals("and"))
				cnt2++;
		System.out.println("No. of times 'and' appears is "+cnt2);
		if(str.startsWith("The"))
			System.out.println("The string starts with 'The'");
		else
			System.out.println("The string does not start with 'The'");
		char[] ch=str.toCharArray();  
		for(i=0;i<ch.length;i++) 
			System.out.print(ch[i]);  
    }
}