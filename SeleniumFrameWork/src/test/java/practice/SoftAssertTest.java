package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {
	@Test
	public void createContact() {
		System.out.println("step1");
		System.out.println("step2");
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(true,false);
		System.out.println("step3");
		System.out.println("step4");
		System.out.println("step5");
		System.out.println("step6");
		soft.assertAll();
	}

	@Test 
	public void m1() {
		String  expdata ="diya";
		String actdata="diya";
		Assert.assertEquals(actdata, expdata);
	}	

	
}
