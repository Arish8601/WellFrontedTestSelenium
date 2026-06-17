package Arish.com.Well.testcases.rahulshettyacademy.com;

import java.io.IOException;
import org.testng.annotations.Test;

import com.Well.Engine.ArishBaseClass;
import com.Well.Engine.BaseClass;

public class Arish_TC_01_LoginTest extends ArishBaseClass {

	@Test
	public void Arish_TC_01_LoginMethod() throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"WELL Login Functionality" );
		try {
		//arishLogin.Login();
			
	} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
