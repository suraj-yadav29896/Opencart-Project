package pomObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPassword_Page {


	private WebDriver driver;

	//constructor
	public ForgotPassword_Page(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	//webElement
	@FindBy(xpath="//input[@id='input-email']") private WebElement emailAddres;
	@FindBy(xpath="//input[@type='submit']") private WebElement submitBtn;
	@FindBy(xpath="//h1[text()='Forgot Your Password?']") private WebElement fpassPgaeVarify;

	// action method

	public void enterEmailAdd(String eml)
	{
		emailAddres.sendKeys(eml);
	}
	public void ClickFPsubmitBtn()
	{
		submitBtn.click();
	}
	public String varifyFPassPage()
	{
		String vp=fpassPgaeVarify.getText();
		return vp;
	}

}
