package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pomObjects.ForgotPassword_Page;
import pomObjects.HomePage;
import pomObjects.LoginPage;
import testBase.BaseClass;

public class Tc004_ForgotPasswordFunctinalityTest extends BaseClass
{
	@Test


		public void varifyForgotPass_PageFunctinality()
		{   
			try {
				//homepage

				HomePage hp=new HomePage(driver);
				hp.click_MyAccount();
				hp.click_Login();
				//LoginPage
				LoginPage lp=new LoginPage(driver);
				lp.clickLnkForgotPass();
				ForgotPassword_Page fp=new ForgotPassword_Page(driver);
				Assert.assertEquals(fp.varifyFPassPage(), "Forgot Your Password?");
				fp.enterEmailAdd(p.getProperty("Email"));
				fp.ClickFPsubmitBtn();
				Assert.assertEquals(lp.getConfirMsg(),"An email with a confirmation link has been sent your email address.");
			}
			catch(Exception e) 
			{
				Assert.fail();
			}





		}

	}
