// YOU SHOULD NOT MODIFY THIS FILE

import java.util.*;

public class MyDateDriver {

  public static void main(String[] args) {

    //
    // The following fragment tests your implementation of equals
    //
    System.out.println("Test the correctness of method equals...");
    MyDate date1 = new MyDate(2018, 3, 16);
    MyDate date2 = new MyDate(2018, 3, 16);
    System.out.println("date1.equals(date2) returns " + date1.equals(date2));
    System.out.println();

    //
    // The following section tests your SortingMyDate.java
    //
    MyDate dates[] = new MyDate[10];

    dates[0] = new MyDate(1997, 7, 1);
    dates[1] = new MyDate(1911, 10, 10);
    dates[2] = new MyDate(1945, 8, 15);
    dates[3] = new MyDate(1842, 8, 29);
    dates[4] = new MyDate(1898, 6, 9);
    dates[5] = new MyDate(1860, 10, 18);
    dates[6] = new MyDate(1962, 9, 1);
    dates[7] = new MyDate(2003, 4, 1);
    dates[8] = new MyDate(2011, 8, 18);
    dates[9] = new MyDate(1910, 3, 16);

    ArrayList<MyDate> dateList = new ArrayList<MyDate>();
    SortingMyDate.ascendSort(dates, dateList);

    System.out.println("Dates in ascending order:");
    System.out.println(dateList);

    dateList = new ArrayList<MyDate>();
    SortingMyDate.descendSort(dates, dateList);

    System.out.println("\nDates in descending order:");
    System.out.println(dateList);
  }
}
