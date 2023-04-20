package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic_utility.Excel_Utility;

public class DataProviderExcel{
	@Test(dataProvider="dataProvider")
	public void bookTickets(String src,String dest) {
		System.out.println("book tickets from" +src+ "to" +dest);
		
	}
	
	
	@DataProvider
	public Object[][] dataProvider() throws Throwable {
		Excel_Utility elib=new Excel_Utility();
	 Object[][] value = elib.getDataProviderData("dataprov");
	 return value;
	}	
	
	/*public Object[][] dataProvider() throws Throwable {
			Excel_Utility excelData=new Excel_Utility();
			Object[][] objarr=new Object[3][2];
			{
				for(int i=0;i<3;i++) {
					for(int j=0;j<2;j++) {
						objarr[i][j]=excelData.getExcelData("dataprov", i, j);
						
					}
				}
				return objarr;
			
		}*/
		
	}

