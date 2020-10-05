import java.util.Scanner;

class Metric
{
    void convertInKM(double mile)
    {
        double km = mile*1.5;
        System.out.println("distance in kilometers: " + km);
    }
    void convertInMile(double km)
    {
        double mile = km/1.5;
        System.out.println("distance in miles: " + mile);
    }

}

public class s1q10
{
    public static void main(String args[])
    {
        Metric m = new Metric();
        Scanner ip = new Scanner(System.in);
        double dist;
        System.out.print("Enter your distance in km: ");
        dist = ip.nextDouble();
        m.convertInMile(dist);

        System.out.print("Enter your distance in mile: ");
        dist = ip.nextDouble();
        m.convertInKM(dist);
        ip.close();
    }
}