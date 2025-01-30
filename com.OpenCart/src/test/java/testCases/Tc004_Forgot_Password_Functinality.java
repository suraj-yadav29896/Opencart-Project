package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pomObjects.ForgotPasswordPage;
import pomObjects.HomePage;
import pomObjects.LoginPage;
import testBase.BaseClass;

public class Tc004_Forgot_Password_Functinality extends BaseClass
{
	@Test(groups={"sanity","master"})

	public void varified_forgot_functinality() throws InterruptedException
	{
		try
		{
			logger.info("**********start test case Tc004_forgot password Test *********");
		
		//HomePgae
		HomePage hp=new HomePage(driver);
		hp.click_MyAccount();
		hp.click_MyAccount();
		hp.click_Login();
		LoginPage lp =new LoginPage(driver);
		lp.clickLnkForgotPass();
		ForgotPasswordPage fp=new ForgotPasswordPage(driver);
		fp.sendEmailFrgot(p.getProperty("Email"));
		Thread.sleep(2000);
		fp.forGotsubmitButton();
		Assert.assertEquals("Success: Your password has been successfully updated.",fp.varificationMsg());
	}
		catch(Exception e)
		{
			Assert.fail();
		}
	}
}
