package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientRecordPage {
	
	WebDriver driver;
	
	public PatientRecordPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='float-sm-right']/span")
	WebElement PatientID;
	public WebElement patient_id()
	{
		return PatientID;
	}
	
	@FindBy(css="a>i.icon-home")
	WebElement Home;
	public void home()
	{
		Home.click();
	}
	
	
	@FindBy(xpath="//span/ancestor::td")
	List<WebElement> Patient;
	public List<WebElement> patient()
	{
		return Patient;
	}
	
	
	@FindBy(css="span.PersonName-givenName")
	WebElement GivenName;
	public WebElement givenName()
	{
		return GivenName;
	}
	
	@FindBy(css="span.PersonName-familyName")
	WebElement FamilyName;
	public WebElement familyName()
	{
		return FamilyName;
	}
	
	@FindBy(css="span#coreapps-showContactInfo")
	WebElement ShowContact;
	public void showContact()
	{
		ShowContact.click();
	}
	
	@FindBy(xpath="(//div[@class='contact-info-inline labeled']/span)[1]")
	WebElement Address;
	public WebElement address()
	{
		return Address;
	}
	
	
	@FindBy(css="span#coreapps-telephoneNumber")
	WebElement Phone;
	public WebElement phone()
	{
		return Phone;
	}
	
	@FindBy(css="input#patient-search")
	WebElement Search;
	public WebElement search()
	{
		return Search;
	}
	
	
	@FindBy(xpath="//div[contains(text(),'Request Appointment')]")
	WebElement ReqAppointment;
	public WebElement reqAppointment()
	{
		return ReqAppointment;
	}
	
	
	@FindBy(xpath="//div[contains(text(),'Schedule Appointment')]")
	WebElement ScheduleAppointment;
	public WebElement scheduleAppointment()
	{
		return ScheduleAppointment;
	}
	
	
	@FindBy(css="i.icon-paper-clip")
	WebElement Attachments;
	public WebElement attachments()
	{
		return Attachments;
	}
	
	@FindBy(css="div.dz-default")
	WebElement FileDrop;
	public WebElement fileDrop()
	{
		return FileDrop;
	}
	
	
	@FindBy(xpath="//div[contains(text(),'Start Visit')]")
	WebElement StartVisit;
	public void startVisit()
	{
		StartVisit.click();
		driver.findElement(By.cssSelector("button#start-visit-with-visittype-confirm")).click();
	}
	
	@FindBy(css="textarea.ng-valid")
	WebElement Caption;
	public WebElement caption()
	{
		return Caption;
	}
	
	
	@FindBy(xpath="//button[contains(text(),'Upload file')]")
	WebElement Upload;
	public WebElement upload()
	{
		return Upload;
	}
	
	@FindBy(css="div.ng-binding>i.icon-file")
	WebElement AttachmentFile;
	public WebElement attachmentFile()
	{
		return AttachmentFile;
	}
	
	@FindBy(xpath="//div[contains(text(),'Delete Patient')]")
	WebElement DeletePatinet;
	public WebElement deletePatient()
	{
		return DeletePatinet;
	}
	
	@FindBy(css="input#delete-reason")
	WebElement Reason;
	public WebElement reason()
	{
		return Reason;
	}
	
	@FindBy(xpath="(//div[@id='delete-patient-creation-dialog']/descendant::button)[1]")
	WebElement Confirm;
	public WebElement confirm()
	{
		return Confirm;
	}

}
