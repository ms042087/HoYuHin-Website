
public class Check {
private String payee;
private static int checkTotal = 1001;
private int checkNum;
private int amount;
private MyDate date;

Check(String name, int amt, MyDate date){
	payee = name;
	amount = amt;
	this.date = date;
	checkNum = checkTotal++;
}

public String getName(){
	return payee;
}
public int getAmount(){
	return amount;
}
public MyDate getDate(){
	return date;
}
public static int getCheckTotal(){
	return checkTotal;
}

}
