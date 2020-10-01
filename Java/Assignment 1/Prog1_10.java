import java.util.*;

class Metric{
	
	double toMiles(double km){
		return km/1.5;
	}
	double toKilometres(double mile){
		return mile*1.5;
	}
	
	public static void main(String args[]){
		Metric m = new Metric();
		System.out.println("In miles : "+ m.toMiles(1.5));
		System.out.println("In kilometers : "+ m.toKilometres(1));
	}
}
