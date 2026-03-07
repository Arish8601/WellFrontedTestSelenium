package com.Well.testcases.V2Project;

import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.Well.Engine.BaseClass;

public class V1_TC_42_V1ProjectRecertificationTest extends BaseClass {
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V1_TC_41_EquityAchievementTest.V1_TC_41_00_V1ProjectEquityAchievement" })
	@Parameters({"SheetName","rowNum", "Country"})
	public void V1_TC_42_00_V1ProjectRecertification(String SheetName, int rowNum, String Country) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate V1 Project Recertification Functionality");
		try {
			rc.SignOut();
			login.AdminLogin();
			v2project.AdminSearchById(SheetName, rowNum);
			v2project.validateV2PilotNonCoreProjectAdminCertification(SheetName, rowNum);
			
		} 
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
