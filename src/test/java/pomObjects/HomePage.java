package pomObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage 
{
	private WebDriver driver;

	//constructor
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	//webeelements

	//@FindBy(xpath="//span[normalize-space()='My Account']")private WebElement MyAccount;
	@FindBy(xpath="	//span[text()='My Account']")private WebElement MyAccount;
	//@FindBy(xpath="//a[normalize-space()='Register']")private WebElement Register;
	@FindBy(xpath="//ul//a[text()='Register']")private WebElement Register;
	//@FindBy(xpath="//a[normalize-space()='Login']")private WebElement Login;
	@FindBy(xpath="//ul//a[text()='Login']")private WebElement Login;

	// action methods 
	public void click_MyAccount()
	{
		MyAccount.click();
	}
	public void click_Register()
	{
		Register.click();
	}

	public void click_Login()
	{
		Login.click();
	}
	public void OtherOptClick()
	{
		Actions at =new Actions(driver);
		at.moveToElement(MyAccount).click().perform();

	}
}
