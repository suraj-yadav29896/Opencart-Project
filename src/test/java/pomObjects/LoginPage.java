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
	@FindBy(xpath="//input[@type='submit']") private WebElement loginclk;
	
	@FindBy(xpath="//div[@class='form-group']//a[text()='Forgotten Password']") private WebElement forgotPassword;
	@FindBy(xpath="//div[text()='An email with a confirmation link has been sent your email address.']")
	private WebElement mailConfAlertMsg;
	@FindBy(xpath="//div[text()='Warning: The E-Mail Address was not found in our records, please try again!']")
	private WebElement mailConfWarningMsg;
	
	
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

	public String getConfirMsg()
	{
		String confmsg=mailConfAlertMsg.getText();
		return confmsg;
	}
	public String getWarningMsg()
	{
		String warnmsg=mailConfWarningMsg.getText();
		return warnmsg;
	}
}
