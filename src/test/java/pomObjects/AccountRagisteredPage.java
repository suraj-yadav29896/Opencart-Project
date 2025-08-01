package pomObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AccountRagisteredPage
{
     public WebDriver driver;
	
	//cunstructor
	
	public AccountRagisteredPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);

	}
	// webelements
	@FindBy(xpath="//input[@id='input-firstname']") private WebElement txtfirstname;
	@FindBy(xpath="//input[@id='input-lastname']") private WebElement txtlastname;
	@FindBy(xpath="//input[@id='input-email']") private WebElement txtemail;
	@FindBy(xpath="//input[@id='input-telephone']") private WebElement telephone;
	@FindBy(xpath="//input[@id='input-password']") private WebElement txtpassword;
	@FindBy(xpath="//input[@id='input-confirm']") private WebElement confirmPass;
	//@FindBy(xpath="//input[@name='newsletter']") private  WebElement ckckdSubscribe;
	@FindBy(xpath="//input[@name='agree']") private WebElement ckcbpolicy;
	@FindBy(xpath="//input[@type='submit']") private WebElement BtnContine;
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']") private WebElement CfmMassge;
	
	//action method
	public void setFirstName(String fname)
	{
		txtfirstname.sendKeys(fname);
	}

	public void setLastName(String lname)
	{
		txtlastname.sendKeys(lname);
	}

	public void setEmail(String email)
	{
		txtemail.sendKeys(email);
	}
	public void set_telephone(String phone)
	{
		telephone.sendKeys(phone);
	}
	
	public void setPassword(String pass)
	{
		txtpassword.sendKeys(pass);
	}

	public void setconfirmPassword(String pass)
	{
		confirmPass.sendKeys(pass);
	}

	public void ClickSubscibeBox(String a)
	{
		
	}

	public void setkPolicy()
	{
		Actions at =new Actions(driver);
		at.moveToElement(ckcbpolicy).click().perform();
	}

	public void ClickContinueBtn()
	{
		BtnContine.click();
	}
	public void OtherOpt_BtnClick()
	{
		Actions at =new Actions(driver);
		at.moveToElement(BtnContine).click().perform();

	}

	public String getconfirmationMsg()
	{
		try {
			return (CfmMassge.getText());
		}
		catch (Exception e)
		{
			return(e.getMessage());
		}
	}




}
