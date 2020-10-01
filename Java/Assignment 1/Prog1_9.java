class BankAcct{
	long acc;
	double bal;
	static double rate;
	
	static void initRate(double val){
		rate = val;
	}
	static void displayRate(){
		System.out.println("Rate : " + rate);
	}
	BankAcct(long  acc, double bal){
		this.acc = acc;
		this.bal = bal;
	}
	double returnBal(){
		return bal;
	}
	void calcInterest(){
		//System.out.println(bal);
		double interest = bal * rate / 100.0;
		System.out.println("Interest : " + interest);
	}
	public static void main(String args[]){
		long  accnum = 17892;
		BankAcct b1 = new BankAcct(accnum, 50000.0);
		b1.initRate(5);
		b1.calcInterest();
	}
	
		
}
