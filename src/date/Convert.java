package date;

import java.util.Date;

public class Convert {
public static void main(String[] args){
	Date d = new Date(1429772455L * 1000);
	System.out.println(d);
	
	Date d1 = new Date(1429772793L * 1000);
	System.out.println(d1);
}
}
