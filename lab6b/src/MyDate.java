// a class for representing dates
public class MyDate {
  private int year, month, day;

  // constructor
  public MyDate(int year, int month, int day) {
    this.year = year;
    this.month = month;
    this.day = day;
  }

  public int getYear() { return year; }

  public int getMonth() { return month; }

  public int getDay() { return day; }

  public boolean equals(MyDate date){
	  if(date.year==this.year&&date.month==this.month&&date.day==this.day) return true;
	  return false;
  }
  public int compareTo(MyDate date){

		  if(date.year<this.year)
			  return -1;
		  else if (date.year>this.year)
			  return 1;
		  else{
			  if(date.month<this.month)
				  return -1;
			  else if (date.month>this.month)
				  return 1;
			  else {
				  if(date.day<this.day)
					  return -1;
				  else if (date.day>this.day)
					  return 1;
			  }
		  }
	  
			 return 0;
		  
  }
  
  // print out date in the form of DD/MM/YYYY
  // no preceding zero for DD and MM
  public String toString() {
    return day + "/" + month + "/" + year;
  }
}
