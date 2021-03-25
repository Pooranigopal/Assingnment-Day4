package Week2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {
		
	/*Pseudo Code	 * 
	 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"	 * 
	 * 2. Enter UserName and Password Using Id Locator	 * 
	 * 3. Click on Login Button using Class Locator	 * 
	 * 4. Click on CRM/SFA Link	 * 
	 * 5. Click on contacts Button	 * 
	 * 6. Click on Create Contact	 *  
	 * 7. Enter FirstName Field Using id Locator	 * 
	 * 8. Enter LastName Field Using id Locator	 * 
	 * 9. Enter FirstName(Local) Field Using id Locator	 * 
	 * 10. Enter LastName(Local) Field Using id Locator	 * 
	 * 11. Enter Department Field Using any Locator of Your Choice	 * 
	 * 12. Enter Description Field Using any Locator of your choice 	 * 
	 * 13. Enter your email in the E-mail address Field using the locator of your choice	 * 
	 * 14. Select State/Province as NewYork Using Visible Text	 * 
	 * 15. Click on Create Contact	 * 
	 * 16. Click on edit button 	 * 
	 * 17. Clear the Description Field using .clear	 * 
	 * 18. Fill ImportantNote Field with Any text	 * 
	 * 19. Click on update button using Xpath locator	 * 
	 * 20. Get the Title of Resulting Page.  */

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromiumdriver().setup();	
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//Launch the URL	
		driver.get("http://leaftaps.com/opentaps/control/login");
		System.out.println("The Leaftaps applicaiton launched sucessfully");
		
		//maximize the window
		driver.manage().window().maximize();
		
		//Enter the username and password		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");	
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		System.out.println("Entered User Name and Password");
		
		
		//get screenshot	
		File login = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(login, new File("./Screenshot/loginscreen1.jpeg"));
		
		//click on login button
	    driver.findElement(By.className("decorativeSubmit")).click();
	    System.out.println("Application login sucessfully");
	    
	    //Click on CRM/SFA Link	 * 
	    driver.findElement(By.linkText("CRM/SFA")).click();	
	    System.out.println("clicked on CRM/SFA link sucessfully");
	    
	    //Click on contacts Button
	    driver.findElement(By.linkText("Contacts")).click();
	    System.out.println("Clicked on Contact Tab");
	    
	    //Click on Create Contact
	    driver.findElement(By.xpath("//ul[@class='shortcuts']//li[2]/a")).click();
	    System.out.println("Clicked on CreateContact option");
	    
	    //Enter FirstName Field Using id Locator
	    driver.findElement(By.id("firstNameField")).sendKeys("Annapoorani");
	    System.out.println("First Name Entered ");
	    
	    //Enter LastName Field Using id Locator
	    driver.findElement(By.id("lastNameField")).sendKeys("Gopalakrishnan");
	    System.out.println("Lasst Name Entered");
	    
	    //Enter FirstName(Local) Field Using id Locator
	    driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Poorani");
	    System.out.println("First Name local Entered ");
	    
	    //Enter LastName(Local) Field Using id Locator	    
	    driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Gopal");
	    System.out.println("Last Name local Entered ");
	    
	    //Enter Department Field Using any Locator of Your Choice
	    driver.findElement(By.id("createContactForm_departmentName")).sendKeys("IT Health Care");
	    System.out.println("Department Entered ");
	    
	    //Enter Description Field Using any Locator of your choice
	    driver.findElement(By.id("createContactForm_description")).sendKeys("Test Automation Training");
	    System.out.println("Description entered ");
	    
	    //Enter your email in the E-mail address Field using the locator of your choice
	    driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("pooranigopal@gmail.com");
	    System.out.println("Entered the Email Id ");
	    
		//get screenshot	
		File snapshot = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(snapshot, new File("./Screenshot/CreateContact1.jpeg"));
	    
	    //Select State/Province as NewYork Using Visible Text		
		WebElement state = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select provstate = new Select(state);
		provstate.selectByVisibleText("New Hampshire");
		System.out.println("The state selected as : New Hampshire ");
	    
	    //Click on Create Contact
		driver.findElement(By.className("smallSubmit")).click();
		System.out.println("Clicked on Create Contact button ");
	    
	    //Click on edit button
		driver.findElement(By.xpath("//div[@class='frameSectionExtra']//a")).click();
		System.out.println("Clicked on Edit button ");
		
		//get screenshot	
		File edit = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(edit, new File("./Screenshot/editscreen1.jpeg"));
	    
	    //Clear the Description Field using .clear		
		 driver.findElement(By.id("updateContactForm_description")).clear();		 
		 System.out.println("Cleared the Description ");
	    
	    // Fill ImportantNote Field with Any text		 
		 driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Exisiting Description cleared and updating notes");
		 System.out.println("Updated in the important Note ");
		 
		//get screenshot	
		File imp = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(imp, new File("./Screenshot/CreateContact2.jpeg"));
			
	    //Click on update button using Xpath locator
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		 System.out.println("Contact Updated Sucessfully ");
		 
	    
	    // Get the Title of Resulting Page.		
		String title = driver.getTitle();
		System.out.println("The Title of the create contact page is: " + title );
	    
		//Close the chrome
		driver.close();
		System.out.println("Browser Closed sucessfully");
	    
		
	}

}
