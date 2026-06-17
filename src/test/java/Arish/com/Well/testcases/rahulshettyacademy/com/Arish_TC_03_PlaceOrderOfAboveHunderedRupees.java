package Arish.com.Well.testcases.rahulshettyacademy.com;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.ArishBaseClass;

public class Arish_TC_03_PlaceOrderOfAboveHunderedRupees extends ArishBaseClass {
	
	@Test(dependsOnMethods = { "Arish.com.Well.testcases.rahulshettyacademy.com.Arish_TC_02_EndToEndTestCase.Arish_TC_02_EndToEndTestCaseFunction" })
	@Parameters({ "SheetName","rowNum" })
	public void Arish_TC_03_PlaceOrderOfAboveHunderedRupeesFunction(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"PlaceOrderOfAboveHunderedRupeesFunction");

		try {
			arishLogin.placeOrderOfAboveHunderedRupees();	
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
