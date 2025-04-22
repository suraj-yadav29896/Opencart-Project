package pomObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {
	public WebDriver driver;

	//cunstructor

	public ForgotPasswordPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);

	}

	//	WebElement sendEmailFrgot;
	//WebElement forGotsubmitButton;

	@FindBy (xpath="//input[@id='input-email']") 	private WebElement sendEmailFrgot;
	@FindBy (xpath="//button[text()='Continue']") private	WebElement forGotsubmitButton;
	@FindBy (xpath="//div[@class='alert alert-success alert-dismissible']") private	WebElement varificationMsg;
	
	public void sendEmailFrgot(String e)
	{
		sendEmailFrgot.sendKeys(e);
	}
	public void forGotsubmitButton()
	{
		forGotsubmitButton.click();
	}
	
	public String varificationMsg()
	{
		String msg=varificationMsg.getText();
		return msg;
	}


}
