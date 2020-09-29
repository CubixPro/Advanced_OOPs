import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Account {
    String accNum;
    String accName;
    float balance;

    public Account() {}

    public Account(String accNum , String accName , float balance) {
        this.accNum = accNum;
        this.accName = accName;
        this.balance = balance;
    }

    public void getData() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Acc. Number : ");
        accNum = in.nextLine();
        System.out.print("Enter Acc. Name : ");
        accName = in.nextLine();
        System.out.print("Enter Balance : ");
        balance = Float.parseFloat(in.nextLine());
        System.out.print("\n");
    }

    public String toString() {
        return "\nAccount Num: " + accNum + "\nAccount Name: " + accName + "\nBalance: " + balance;
    }
}

class AccountsCollection {
    HashMap<String , Account> map;

    public AccountsCollection() {
        map = new HashMap<>();
    }

    public boolean isPresent(String accNum) {
        if(map.containsKey(accNum)) {
            return true;
        }
        return false;
    }

    public void add(Account obj) {
        if(!isPresent(obj.accNum)) {
            map.put(obj.accNum , obj);
        }
        else {
            System.out.println("Account Number already present!!");
        }
    }

    public float checkBal(String accNum) {
        if(!isPresent(accNum)) {
            System.out.println("Account not found!!");
        }
        return map.get(accNum).balance;
    }

    public void printAll() {
        for(Map.Entry<String, Account> ele : map.entrySet()) {
            System.out.println(ele.getValue());
        }
    }
}

public class Prog3_2 {
    public static void main(String[] args) {
        Account a1 = new Account() , a2 = new Account();
        a1.getData();
        a2.getData();

        AccountsCollection collec = new AccountsCollection();
        collec.add(a1);
        collec.add(a2);

        collec.printAll();
    }
}