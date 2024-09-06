package pomObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount_Page {
	private WebDriver driver;

	//constructor
	public MyAccount_Page(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	//webElement
	@FindBy(xpath="//h2[normalize-space()='My Account']") private WebElement HdingmyaccoPgae;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") private WebElement logoutBtn;
	//action maehod 
	public boolean ismyaccount_pageHaeding()
	{
		try {
			return(HdingmyaccoPgae.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}

	}
	public void clickLogOutBtn()
	{
		Actions at =new Actions(driver);
		at.moveToElement(logoutBtn).click().perform();
	}
}
