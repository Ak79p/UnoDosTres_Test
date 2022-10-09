package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppointmentPage {
	
	WebDriver driver;
	
	public AppointmentPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input#appointment-type")
	WebElement AppointmentType;
	public WebElement appointmentType()
	{
		return AppointmentType;
	}
	
	
	@FindBy(css="input#min-time-frame-value")
	WebElement MinTime;
	public WebElement minTime()
	{
		return MinTime;
	}
	
	
	@FindBy(css="select#min-time-frame-units")
	WebElement MinTimeUnit;
	public WebElement minTimeUnit()
	{
		return MinTimeUnit;
	}
	
	
	@FindBy(css="input#max-time-frame-value")
	WebElement MaxTime;
	public WebElement maxTime()
	{
		return MaxTime;
	}
	
	
	@FindBy(css="select#max-time-frame-units")
	WebElement MaxTimeUnit;
	public WebElement maxTimeUnit()
	{
		return MaxTimeUnit;
	}
	
	
	@FindBy(css="input#save-button")
	WebElement Save;
	public WebElement save()
	{
		return Save;
	}
	
	@FindBy(xpath="(//div/span[@class='ng-binding'])[1]")
	WebElement ServiceType;
	public WebElement serviceType()
	{
		return ServiceType;
	}
	
	@FindBy(xpath="(//a/strong)[1]")
	WebElement TypeSuggestion;
	public WebElement typeSuggestion()
	{
		return TypeSuggestion;
	}
	
	
	
			
	
	
			

}
