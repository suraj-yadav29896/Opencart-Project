package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pomObjects.AccountRagisteredPage;
import pomObjects.HomePage;
import testBase.BaseClass;

public class Tc001_AccountRegistationTest extends BaseClass{

	@Test(groups={"regration","master"})
	 public void Varify_Account_Registation()
	{
		try {
			HomePage hp=new HomePage(driver);
			hp.click_MyAccount();
			logger.info("***********click on my account link**********");
			
			hp.click_MyAccount();
			hp.click_Register();
			logger.info("***********click on ragistered link**********");
			AccountRagisteredPage Ap =new AccountRagisteredPage(driver);
			logger.info("**********filled the users detials*********");
			Ap.setFirstName(randomstring().toUpperCase());
			Ap.setLastName(randomstring().toUpperCase());
			Ap.setEmail(randomstring().toUpperCase()+"@gmail.com");
			Ap.setPassword("roshan1234");
			Ap.setkPolicy();
			Ap.OtherOpt_BtnClick();
			logger.info("*********start the validation of users*********");
			Assert.assertEquals(Ap.getconfirmationMsg(),"Your Account Has Been Created!");
		}

		catch(Exception e)
		{
         logger.error("test is failed...........");
         logger.debug("debugs logs.......");
         Assert.fail();
		}
	}
	}
	
	
	
	
	
