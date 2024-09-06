package pomObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver driver;

	//constructor
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	//webElement
	@FindBy(xpath="//input[@id='input-email']") private WebElement email;
	@FindBy(xpath="//input[@id='input-password']") private WebElement password;
	@FindBy(xpath="//button[@type='submit']") private WebElement loginclk;
	@FindBy(xpath="//div[@class='mb-3']//a[normalize-space()='Forgotten Password']") private WebElement forgotPassword;
	
	//action method
	public void sendEmail(String e)
	{
		email.sendKeys(e);
	}
	
	public void sendPassword(String p)
	{
		password.sendKeys(p);
	}
	
	public void clickLoginBtn()
	{
		loginclk.click();
	}
	
	public void clickLnkForgotPass()
	{
		forgotPassword.click();
	}
}
