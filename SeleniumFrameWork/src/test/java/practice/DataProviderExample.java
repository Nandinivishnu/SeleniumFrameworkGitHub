package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Objects;

import com.google.common.collect.ObjectArrays;

public class DataProviderExample {
	
	@Test(dataProvider="dataProvider")
	public void bookTickets(String src,String dest) {
		System.out.println("book tickets from" +src+ "to" +dest);
	}
	
	
	@DataProvider
	public Object[][] dataProvider(){
		
		Object[][] objarr=new Object[3][2];
		
		objarr[0][0]="bangalore";
		objarr[0][1]="tumkur";
		
		objarr[1][0]="bangalore";
		objarr[1][1]="goa";
		
		objarr[2][0]="bangalore";
		objarr[2][1]="mysore";
		return objarr;
	}

}
