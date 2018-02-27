import java.util.ArrayList;

public class CheckSummary {
	
public static void printSummary(ArrayList<Check> checks){
	for(int i = 0; i<checks.size();i++){
		Check check = checks.get(i);
		System.out.println("Check No: "+(i+1001)+", Payee: "+check.getName()+", Amount: "+check.getAmount()+", Date: "+check.getDate());
	}
	System.out.println("The next check number is " + (Check.getCheckTotal()));
	int year = checks.get(0).getDate().getYear();
	int month = checks.get(0).getDate().getMonth();
	int totalAmt=0;
	int totalAmtAll = 0;
	int i = 0;
	while(i<checks.size()){
		Check check = checks.get(i);
		while(check.getDate().getYear()==year && check.getDate().getMonth()==month){
			totalAmt += check.getAmount();
			i=i+1;
			if(i<checks.size()-1)
				check = checks.get(i);
			else
				break;
		}
		if(totalAmt!=0)
			System.out.println("The total amount of the checks issued in "+year+"/"+month+" is "+totalAmt);
		totalAmtAll +=totalAmt;
		totalAmt = 0;
		if(month<12)
			month++;
		else{
			month=1;
			year++;
		}

	}
	System.out.println("The total amount is "+totalAmtAll);
}
}
