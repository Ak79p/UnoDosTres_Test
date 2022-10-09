package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="a[href*='/logout']")
	WebElement Logout;
	public WebElement logout()
	{
		return Logout;
	}
	
	
	@FindBy(css="a>i.icon-user")
	WebElement Register;
	public void register()
	{
		Register.click();
	}
	
	@FindBy(css="a>i.icon-search")
	WebElement FindPatient;
	public void find_Patient()
	{
		FindPatient.click();
	}

}
