// YOU SHOULD NOT MODIFY THIS FILE

import java.util.*;

public class CheckDriver {

  public static void main(String[] args) {

    ArrayList<Check> checks = new ArrayList<Check>();

    checks.add(new Check("Peter", 100, new MyDate(2017, 8, 11)));
    checks.add(new Check("Mary", 200, new MyDate(2017, 8, 17)));
    checks.add(new Check("John", 600, new MyDate(2017, 9, 1)));
    checks.add(new Check("John", 400, new MyDate(2017, 10, 12)));
    checks.add(new Check("Mary", 700, new MyDate(2017, 11, 11)));
    checks.add(new Check("Betty", 100, new MyDate(2017, 12, 20)));
    checks.add(new Check("Alice", 300, new MyDate(2018, 1, 5)));
    checks.add(new Check("Peter", 200, new MyDate(2018, 1, 31)));
    checks.add(new Check("Alice", 300, new MyDate(2018, 3, 22)));

    CheckSummary.printSummary(checks);
  }
}
