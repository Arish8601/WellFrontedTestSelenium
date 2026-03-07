package com.Well.testcases.Performance;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Performance_TC_11B_ValidateMainlandChinaProjectWithWellVerifierRoleTest extends BaseClass {
	
	@SuppressWarnings("static-access")
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_21_CloseProjectTest.Performance_TC_21_03_CloseProject" })
	@Parameters({"SheetName","rowNum","DataValidate","Country","ProjectType","Upload","API","Commodity","ImportLocation","ProjectName"})
	public void Performance_TC_11B_00_RegisterMainlandChinaProjectWithWellVerifierRole(String SheetName,int rowNum, String DataValidate, String Country, String ProjectType,String Upload,String API,String Commodity, String ImportLocation, String ProjectName) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Register Mainland China Project With Well Verifier Role");
		try {
			if (TestNGTestName.contains("Main")) {	
			login.AdminLogin();
			int rowNumber = 5;
			performance.RegisterPerformance(SheetName, rowNumber, "MainlandChina", ProjectName);
			}
		    } catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
		
	@SuppressWarnings("static-access")
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_11B_ValidateMainlandChinaProjectWithWellVerifierRoleTest.Performance_TC_11B_00_RegisterMainlandChinaProjectWithWellVerifierRole" })
	@Parameters({ "SheetName","rowNum","Country","ProjectType","API","Commodity","Upload" })	
	public void Performance_TC_11B_01_BillingPerformance(String SheetName,int rowNum, String Country, String ProjectType, String Type, String API, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Performance Project Card Payment Functionality");
		try {
			if (TestNGTestName.contains("Main")) {	
			   int rowNumber = 5;
			   rc.Billing(SheetName, rowNumber);
			   }			
		    } catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_11B_ValidateMainlandChinaProjectWithWellVerifierRoleTest.Performance_TC_11B_00_RegisterMainlandChinaProjectWithWellVerifierRole" })
	@Parameters({ "SheetName","rowNum","API" })
	public void Performance_TC_11B_02_StoreId(String SheetName,int rowNum, String API) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Store Performance Id");

		try {
			if (TestNGTestName.contains("Main")) {	
			int rowNumber = 5;
			performance.StoreIdPerformance(SheetName, rowNumber);	
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_11B_ValidateMainlandChinaProjectWithWellVerifierRoleTest.Performance_TC_11B_02_StoreId" })
	@Parameters({ "SheetName","rowNum" })
	public void Performance_TC_11B_03_AddTeamMemberPerformance(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Add Team Member Performance");
		try {
			if (TestNGTestName.contains("Main")) {	
			int rowNumber = 5;
			rc.TeamPermissionLevel(SheetName, rowNumber);
			rc.SignOut();
			rc.teamMemberLogin(SheetName, rowNumber);
			performance.SearchPerformanceByID(SheetName, rowNumber);
			}
			} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_11B_ValidateMainlandChinaProjectWithWellVerifierRoleTest.Performance_TC_11B_03_AddTeamMemberPerformance" })
	@Parameters({ "SheetName","rowNum" })
	public void Performance_TC_11B_04_ValidateMainlandChinaProjectWithTeamMemberRole(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate Mainland China Project With Team Member Role");
		try {
			if (TestNGTestName.contains("Main")) {	
			int rowNumber = 5;
			v2project.ValidateMainlandChinaProjectWithTeamMemberRole(SheetName, rowNumber);
			}
			} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@SuppressWarnings("static-access")
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_11B_ValidateMainlandChinaProjectWithWellVerifierRoleTest.Performance_TC_11B_04_ValidateMainlandChinaProjectWithTeamMemberRole" })
	@Parameters({"SheetName","rowNum","DataValidate","Country","ProjectType","Upload","API","Commodity","ImportLocation","ProjectName"})
	public void Performance_TC_11B_05_ValidateUpdateForProjectsWithLocationsInChinaModalDuringRegistration(String SheetName,int rowNum, String DataValidate, String Country, String ProjectType,String Upload,String API,String Commodity, String ImportLocation, String ProjectName) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate Update For Projects With Locations In China Modal During Registration");
		try {
			if (TestNGTestName.contains("Main")) {	
			rc.SignOut();
			login.Login();
			performance.ValidateUpdateForProjectsWithLocationsInChinaModalDuringRegistration(SheetName, rowNum, "MainlandChina", ProjectName);
			}
		    } catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
