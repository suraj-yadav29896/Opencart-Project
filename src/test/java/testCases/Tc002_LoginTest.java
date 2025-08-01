package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pomObjects.HomePage;
import pomObjects.LoginPage;
import pomObjects.MyAccount_Page;
import testBase.BaseClass;

public class Tc002_LoginTest extends BaseClass{

	@Test(groups={"sanity","master"})
	public void varified_login_test()
	{
		logger.info("**********start test case Tc002_LoginTest *********");
		try {
			//HomePgae
			HomePage hp=new HomePage(driver);
			hp.click_MyAccount();
			//hp.click_MyAccount();
			hp.click_Login();
			//LoginPage
			LoginPage lp=new LoginPage(driver);
			lp.sendEmail(p.getProperty("Email"));
			lp.sendPassword(p.getProperty(("Password")));
			lp.clickLoginBtn();
			//myaccountPage
			MyAccount_Page map=new MyAccount_Page(driver);
			boolean actual=map.ismyaccount_pageHaeding();
			//Assert.assertTrue(actual);
			Assert.assertEquals(actual,true,"login failed");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("***********finished test case Tc002_LoginTest**********");

	}
	}

