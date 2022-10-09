package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="input[name='givenName']")
	WebElement Name;
	public WebElement name()
	{
		return Name;
	}
	
	@FindBy(css="input[name='familyName']")
	WebElement Family;
	public WebElement family()
	{
		return Family;
	}
	
	@FindBy(css="button#next-button")
	WebElement Next;
	public void next()
	{
		Next.click();
	}
	
	@FindBy(css="select#gender-field")
	WebElement Gender;
	public WebElement gender()
	{
		return Gender;
	}
	
	@FindBy(css="input#birthdateDay-field")
	WebElement Day;
	public WebElement day()
	{
		return Day;
	}
	
	@FindBy(css="select#birthdateMonth-field")
	WebElement Month;
	public WebElement month()
	{
		return Month;
	}
	
	@FindBy(css="input#birthdateYear-field")
	WebElement Year;
	public WebElement year()
	{
		return Year;
	}
	
	@FindBy(css="input#address1")
	WebElement Address;
	public WebElement address()
	{
		return Address;
	}
	
	@FindBy(css="input[name='phoneNumber']")
	WebElement Phone;
	public WebElement phone()
	{
		return Phone;
	}
	
	@FindBy(css="select#relationship_type")
	WebElement Relative_type;
	public WebElement relative()
	{
		return Relative_type;
	}
	
	@FindBy(css="input[ng-model='relationship.name']")
	WebElement Relative_name;
	public WebElement relative_name()
	{
		return Relative_name;
	}			
	
	@FindBy(css="input#submit")
	WebElement Submit;
	public void submit()
	{
		Submit.click();		
	}
	
	

}
