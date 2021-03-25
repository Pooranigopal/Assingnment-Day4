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

public class Xpaths {
		
	/*No need to write Selenium script - Just find these elements in the DOM using only XPaths	
	Try all the xpaths that you've learnt (basic, text-based, axes..)
	1. Launch the URL	
	2. Enter the username based on its label	
	3. Enter the password based on its label	
	4. Click Login	
	5. Click on CRMSFA link	
	6. Click on Leads link	
	7. Click on Merge Leads link	
	8. Click the first img icon	
	9. Select the first resulting lead	
	10. Click the second img icon	
	11. Select the second resulting lead	
	12. Click on Merge Lead (submit) button	
	13. Get the company name text based on its label
	*/

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
		
		//Enter the username and password based on label	
		driver.findElement(By.xpath("//label[@for='username']/following-sibling::input")).sendKeys("DemoSalesManager");	
		driver.findElement(By.xpath("//label[@for='password']/following-sibling::input")).sendKeys("crmsfa");
		System.out.println("Entered User Name and Password");
				
		//get screenshot	
		File login = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(login, new File("./Screenshot/loginscreen1.jpeg"));
		
		//click on login button
	    driver.findElement(By.xpath("//input[@value='Login']")).click();
	    System.out.println("Application login sucessfully");
	    
	    //Click on CRM/SFA Link	 * 
	    driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();	
	    System.out.println("clicked on CRM/SFA link sucessfully");
	    
	    //Click on Leads link
	    driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();	
	    System.out.println("clicked on Leads sucessfully");
		
		//Click on Merge Leads link	
	    driver.findElement(By.xpath("//a[contains(@href,'/crmsfa/control/mergeLeadsForm')]")).click();	
	    System.out.println("clicked on Merge Leads sucessfully");
	    
		//Click the first img icon	
	    driver.findElement(By.xpath("//input[@id='partyIdFrom']/following::a[1]")).click();
	    System.out.println("First Image Clicked Scuessfully");
	    
	    //driver.switchTo().window("Find Leads");
	    
	    driver.switchTo().frame(0);
	    
		//Select the first resulting lead		    
	    driver.findElement(By.xpath("//table[@class ='x-grid3-row-table']//td[1]/div[1]//a")).click();
	    System.out.println("First Lead selected Scuessfully");
	    
		//Click the second img icon		  
	    driver.findElement(By.xpath("//input[@id='partyIdTo']/following::a[1]")).click();
	    System.out.println("Second Image Clicked Scuessfully");
	    
	    //driver.switchTo().window("Find Leads");
	    driver.switchTo().frame(1);
	    
	    //Select the second resulting lead
	    
	    driver.findElement(By.xpath("//div[@class ='x-grid3-row    x-grid3-row-alt']//td[1]/div[1]//a")).click();
	    System.out.println("First Lead selected Scuessfully");
	    
		//Click on Merge Lead (submit) button
	    driver.findElement(By.xpath("//input[@id='partyIdTo']/following::a[1]")).click();
	    System.out.println("First Image Clicked Scuessfully");
	    
	    driver.switchTo().alert().accept();
	    
		//Get the company name text based on its label
	    WebElement name = driver.findElement(By.xpath("//span[@id= 'viewLead_companyName_sp']"));
	    String companyName = name.getText();
	    System.out.println("The Company Name is: " + companyName); 		 
    
		//Close the chrome
		driver.close();
		System.out.println("Browser Closed sucessfully");
	    
		
	}

}
