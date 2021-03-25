package Week2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindContact {
	
	/* //Pseudo Code	 * 
	 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"	 * 
	 * 2. Enter UserName and Password Using Id Locator	 * 
	 * 3. Click on Login Button using Class Locator	 * 
	 * 4. Click on CRM/SFA Link	 * 
	 * 5. Click on contacts Button	 * 
	 * 6. Click on Find Contacts	 * 
	 * 7. Click on the Email Field using Xpath Locator	 *
	 * 8. Enter the email using any locator	 * 
	 * 9. Click on Find Contacts using Xpath Locator	 * 
	 * 10. Click on the First Resulting Contact	 * 
	 * 11. Get the Text of First Name 	 * 
	 * 12. Click on the Edit Button	 * 
	 * 13. Select New Marketing Campaign as eCommerce Site Internal Campaign by using SelectByValue	 * 
	 * 14. Click on the add button	 * 
	 * 15. Enter Department Value as Selenium Automation Testing	 * 
	 * 16. Click on the Update Button	 * 
	 * 17. Get the text of Marketing campaign and Verify it	 * 
	 * 18. verify Title of the Current page	 */

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
		WebDriverManager.chromiumdriver().setup();	
		ChromeDriver driver = new ChromeDriver();
		
		//clear cache
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));		
		
		//Launch the URL	
		driver.get("http://leaftaps.com/opentaps/control/login");
		System.out.println("The Leaftaps applicaiton launched sucessfully");
		
		//clear Chache
		driver.manage().deleteAllCookies();
		
		//maximize the window
		driver.manage().window().maximize();
		
		//clear Chache
		driver.manage().deleteAllCookies();
		
		//Enter the username and password		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");	
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		System.out.println("Entered User Name and Password");		
		
		//get screenshot	
		File findcontact = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(findcontact, new File("./Screenshot/findcontact1.jpeg"));
		
		//click on login button
	    driver.findElement(By.className("decorativeSubmit")).click();
	    System.out.println("Application login sucessfully");
	    
	    //Click on CRM/SFA Link	 * 
	    driver.findElement(By.linkText("CRM/SFA")).click();	
	    System.out.println("clicked on CRM/SFA link sucessfully");
	    
	    //Click on contacts Button
	    driver.findElement(By.linkText("Contacts")).click();
	    System.out.println("Clicked on Contact Tab");
	    
	    //click on find contact
	    driver.findElement(By.linkText("Find Contacts")).click();
	    System.out.println("Clicked on find contacts");
	    
	    //Click on the Email Field using Xpath Locator
	    driver.findElement(By.xpath("//div[@class='x-tab-strip-wrap']//li[3]")).click();
	    System.out.println("The Email tab is clicked");
	    
	    //Enter the email using any locator
	    driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("pooranigopal@gmail.com");
	    System.out.println("Email Address Entered");
	    
	    //Click on Find Contacts using Xpath Locator
	    driver.findElement(By.xpath("//button[contains(text(),'Find Contacts')]")).click();
	    System.out.println("Clicked on Find Contact button");
	    Thread.sleep(3000);
	    
	    //Click on the First Resulting Contact
	   //driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a")).click();
	   WebDriverWait wait = new WebDriverWait(driver, 40);
	   WebElement waituntil = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a")));
	   waituntil.click();
	   System.out.println("Contact Id clicked sucessfully");	
    
	    
	    //Get the Text of First Name
	   
	    WebElement gettext = driver.findElement(By.id("viewContact_firstName_sp"));
	    String text = gettext.getText();
	    System.out.println("the First Name of the user is : " + text );	
	   //table[@class='x-grid3-row-table']//td[3]//a
	  
	    
		//get screenshot	
		File findcon = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(findcon, new File("./Screenshot/findContact2.jpeg"));
	    
	    //Click on the Edit Button
	    driver.findElement(By.xpath("//a[@class='subMenuButtonDangerous']/preceding-sibling::a")).click();
	    System.out.println("Edit button clicked sucessfully");	
	    Thread.sleep(5000);
	    
	    //Select New Marketing Campaign as eCommerce Site Internal Campaign by using SelectByValue
	    WebElement marketcompagin = driver.findElement(By.id("addMarketingCampaignForm_marketingCampaignId"));
	    Select marktCompaign = new Select(marketcompagin);
	    marktCompaign.selectByValue("9000");
	    Thread.sleep(5000);
	    
	  /*  //Remove exisiting values if present
	    WebElement removdep = driver.findElement(By.linkText("eCommerce Site Internal Campaign (9000)"));
	    String depremov = removdep.getText();
	    String replace = depremov.replace(" (9000)", "");    
	    
	     if(replace.equalsIgnoreCase("eCommerce Site Internal Campaign")) {
	     
	    	driver.findElement(By.linkText("Remove")).click();
	    	System.out.println("exisiting department removed sucessfully "+ replace );
	    }
	    	
	    	else {
	    		System.out.println("exisiting department not removed "+ replace );
	    	} 
	     Thread.sleep(5000);*/
	     
	    //Click on the add button
	    driver.findElement(By.xpath("//input[@value='Add']")).click();
	    System.out.println("The Edited information added sucessfully");
	    Thread.sleep(6000);
	    
	    // Enter Department Value as Selenium Automation Testing
	    driver.findElement(By.id("updateContactForm_departmentName")).clear();
	    driver.findElement(By.id("updateContactForm_departmentName")).sendKeys("Selenium Automation Testing");
	    System.out.println("The Department Entered as: Selenium Automation Testing "); 	  
	    Thread.sleep(5000);
	    
		//get screenshot	
		File findconedit = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(findconedit, new File("./Screenshot/findContact3.jpeg"));
	    
	    //Click on the Update Button
		
		 WebDriverWait wait1 = new WebDriverWait(driver, 40);
		 WebElement waituntil1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Update']")));
		 waituntil1.click();
	    //driver.findElement(By.xpath("//input[@value='Update']")).click();
	    System.out.println("information updated sucessfully");
	    Thread.sleep(6000);
	    
	    //Get the text of Marketing campaign and Verify it
	    WebElement getdepart = driver.findElement(By.xpath("//span[@id='viewContact_marketingCampaigns_sp']"));
	    String marcampa = getdepart.getText();
	    if(marcampa.equalsIgnoreCase("eCommerce Site Internal Campaign")) {
	    	System.out.println("Entered Department Name is matched with : "+ marcampa );
	    }
	    	
	    	else {
	    		System.out.println("Entered Department Name is not matched with : "+ marcampa );
	    	}	  
	    
 	    
	    
		//get screenshot	
		File findcontfinal = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(findcontfinal, new File("./Screenshot/findContact4.jpeg")); 
		
	    
	    //verify Title of the Current page
		String title = driver.getTitle();
		System.out.println("The Title of the create contact page is: " + title );
		
	    
		//Close the chrome
		driver.close();
		System.out.println("Browser Closed sucessfully");	    


	}

}
