package org.iit.cloud.mmp.patient.tests;

import org.iit.cloud.mmp.BaseClass;
import org.iit.cloud.mmp.HelperClass;
import org.testng.annotations.Test;

public class US_006_EditProfile extends BaseClass {
	HelperClass helperObj;
 
	@Test(description="TC_001_search_symptoms")
	public void search_symptoms()
	{
		helperObj = new HelperClass(driver);
		helperObj.launchBrowser("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		helperObj.login("ria1","Ria12345");
		helperObj.navigateToAmodule("Messages"); 
	} 
}
