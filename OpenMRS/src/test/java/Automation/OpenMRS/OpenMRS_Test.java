package Automation.OpenMRS;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.AppointmentPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.PatientRecordPage;
import PageObjects.RegisterPage;

public class OpenMRS_Test extends base{
	
	WebDriver driver;
	Actions act;
	LoginPage lp;
	HomePage hp;
	RegisterPage rp;
	PatientRecordPage pr;
	AppointmentPage ap;
	String patientID;

	@BeforeClass
	public void initializeTest() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@AfterClass
	public void tearDown() throws IOException
	{
		driver.close();
	}
	
	@Test(priority=1)
	public void Login_test()
	{
		lp = new LoginPage(driver);
		lp.username().sendKeys(prop.getProperty("username"));
		lp.password().sendKeys(prop.getProperty("password"));
		// Iterate through all location using Java Stream and perform click on desired location
		lp.location().stream().filter(s->s.getText().contains(prop.getProperty("location"))).forEach(s->s.click());
		lp.login().click();
		hp= new HomePage(driver);
		assertTrue(hp.logout().isDisplayed());
	}
	
	@Test(priority=2)
	public void Register_test()
	{
		hp.register();
		rp = new RegisterPage(driver);
		rp.name().sendKeys(prop.getProperty("name"));
		rp.family().sendKeys(prop.getProperty("family"));
		rp.next();
		Select gender = select(rp.gender());
		gender.selectByVisibleText(prop.getProperty("gender"));
		rp.next();
		rp.day().sendKeys(prop.getProperty("day"));
		rp.month().sendKeys(prop.getProperty("month"));
		rp.year().sendKeys(prop.getProperty("year"));
		rp.next();
		rp.address().sendKeys(prop.getProperty("address"));
		rp.next();
		rp.phone().sendKeys(prop.getProperty("phone"));
		rp.next();
		Select relation = select(rp.relative());
		relation.selectByVisibleText(prop.getProperty("relation"));
		rp.relative_name().sendKeys(prop.getProperty("relation_name"));
		rp.next();
		rp.submit();
		pr= new PatientRecordPage(driver);
		patientID=pr.patient_id().getText();
	}
	
	@Test(priority=3)
	public void findPatient_test()
	{
		pr.home();
		hp.find_Patient();
		assertTrue(pr.patient().stream().anyMatch(s->s.getText().contains(patientID)));
	}
	
	@Test(priority=4)
	public void viewPatient_Test()
	{
		pr.search().sendKeys(patientID);
		act= new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
		assertTrue(pr.givenName().getText().contains(prop.getProperty("name")));
		assertTrue(pr.patient_id().getText().contains(patientID));
		assertTrue(pr.familyName().getText().contains(prop.getProperty("family")));
		pr.showContact();
		assertTrue(pr.address().getText().contains(prop.getProperty("address")));
		assertTrue(pr.phone().getText().contains(prop.getProperty("phone")));
	}
	
	@Test(priority=5)
	public void bookAppointment_Test()
	{
		pr.reqAppointment().click();
		ap=new AppointmentPage(driver);
		ap.appointmentType().sendKeys(prop.getProperty("serviceType"));
		if(ap.typeSuggestion().getText().contains(prop.getProperty("serviceType")))
		{
			ap.typeSuggestion().click();
		}
		ap.minTime().sendKeys("1");
		select(ap.minTimeUnit()).selectByVisibleText("Day(s)");
		ap.maxTime().sendKeys("2");
		select(ap.maxTimeUnit()).selectByVisibleText("Day(s)");
		ap.save().click();
		pr.scheduleAppointment().click();
		assertTrue(ap.serviceType().getText().contains(prop.getProperty("serviceType")));
		pr.home();
	}
	
	@Test(priority=6)
	public void addAttachment_Test() throws InterruptedException
	{
		hp.find_Patient();
		pr.search().sendKeys(patientID);
		act= new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
		pr.startVisit();
		Thread.sleep(7000);
//		WebDriverWait wait = new WebDriverWait(driver,30);
//		wait.until(ExpectedConditions.visibilityOf(pr.attachments()));
		pr.attachments().click();
		pr.caption().sendKeys("Attached Medical report");
		DropFile(new File(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Medical Report.txt"),pr.fileDrop(), 0, 0);
		pr.upload().click();
		assertTrue(pr.attachmentFile().isDisplayed());
	}
	
	@Test(priority=7)
	public void delete_Test()
	{
		pr.home();
		hp.find_Patient();
		pr.search().sendKeys(patientID);
		act.sendKeys(Keys.ENTER).build().perform();
		pr.deletePatient().click();
		pr.reason().sendKeys(prop.getProperty("reason"));
		pr.confirm().click();
		assertFalse(pr.patient().stream().anyMatch(s->s.getText().contains(patientID)));
	}
	
	@Test(priority=8)
	public void logout_Test() throws InterruptedException
	{
		Thread.sleep(3000);
		hp.logout().click();
		assertTrue(lp.login().isDisplayed());
	}
	
	

}
