import java.util.*;

public class SortingMyDate {

  // for simplicify, you can assume list has been instantiated but
  // is currently empty
  // arrange the dates from earlier to later
  public static void ascendSort(MyDate[] arr, ArrayList<MyDate> list) {
    list.add(arr[0]);
    while(arr.length!=list.size()){
    	System.out.println(list.size());
    	for(int i=1; i<arr.length;i++){
    		int j=0;
    		while(j<list.size()-1){
    			if(list.get(j).compareTo(arr[i])!=-1){
    				list.add(j+1,arr[i]);
    				break;
    			}
    			j++;
    		}
    	}
    }
  }

  // for simplicify, you can assume list has been instantiated but
  // is currently empty
  // arrange the dates from later to earlier
  public static void descendSort(MyDate[] arr, ArrayList<MyDate> list) {
	    list.add(arr[0]);
	    while(arr.length!=list.size()){
	    	for(int i=1; i<arr.length;i++){
	    		int j=0;
	    		while(j<list.size()-1){
	    			if(list.get(j).compareTo(arr[i])!=1){
	    				list.add(j+1,arr[i]);
	    				break;
	    			}
	    			j++;
	    		}
	    	}
	    }
  }
}
