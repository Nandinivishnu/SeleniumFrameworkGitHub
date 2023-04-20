package practice;


import org.testng.annotations.Test;

public class SampleTestNg {
	@Test(invocationCount = 1)
	
		public void createContact() {
			System.out.println("contact created");
		}
	@Test(dependsOnMethods ="deleteContact" )
		public void modifyContact()
		{
			System.out.println("modfied contact");
		}
	@Test(priority = 2)
		public void deleteContact() {
			System.out.println("deleted contact");
		}
	
}