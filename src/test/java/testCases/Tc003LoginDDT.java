package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pomObjects.HomePage;
import pomObjects.LoginPage;
import pomObjects.MyAccount_Page;
import testBase.BaseClass;
import utilities.DataProviders;

/* Data is valid - login success - test pass - logout
 * Data is valid - login failed  -test failed
 
  Data is invalid -login success - test failed -logout
  Data is invalid -login failed - test passed 
 
 */
public class Tc003LoginDDT extends BaseClass{

	@Test (dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="master")
	//when dataprovider method in same class the no need for taking dataprovider class
	//but data provider class is in differant location(differant package and class) the provide the name oof class
	public void varify_LoginDDT(String email,String pass,String exp)
	{
		logger.info("**********start test case Tc003LoginDDT *********");
		try {
			//HomePgae
			HomePage hp=new HomePage(driver);
			hp.click_MyAccount();
			//hp.click_MyAccount();
			hp.click_Login();
			//LoginPage
			LoginPage lp=new LoginPage(driver);
			lp.sendEmail(email);
			lp.sendPassword(pass);
			lp.clickLoginBtn();
			//myaccountPage
			MyAccount_Page map=new MyAccount_Page(driver);
			boolean actual=map.ismyaccount_pageHaeding();

			/* Data is valid - login success - test pass - logout
			 * Data is valid - login failed  -test failed
			 
			  Data is invalid -login success - test failed -logout
			  Data is invalid -login failed - test passed 
			 
			 */
			if(exp.equalsIgnoreCase("valid"))
			{
				if(actual==true)
				{
					map.clickLogOutBtn();
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);
				}
			}
			if(exp.equalsIgnoreCase("invalid"))
			{
				if(actual==true)
				{
					map.clickLogOutBtn();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("**********finished test case Tc003LoginDDT *********");
	}
}
