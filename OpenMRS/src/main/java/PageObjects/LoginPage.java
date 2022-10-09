package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input#username")
	WebElement Username;
	public WebElement username()
	{
		return Username;
	}
	
	
	@FindBy(css="input#password")
	WebElement Password;
	public WebElement password()
	{
		return Password;
	}
	
	
	@FindBy(xpath="//ul[@id='sessionLocation']/li")
	List<WebElement> Location;
	public List<WebElement> location()
	{
		return Location;
	}
	
	
	@FindBy(css="input#loginButton")
	WebElement Login;
	public WebElement login()
	{
		return Login;
	}

}
