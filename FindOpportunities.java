package Week2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindOpportunities {
		/* //Pseudo Code	 * 
	 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"	 * 
	 * 2. Enter UserName and Password Using Xpath Locator	 * 
	 * 3. Click on Login Button using Xpath Locator	 * 
	 * 4. Click on CRM/SFA Link	 * 
	 * 5. Click on Oppurtunites Button	 * 
	 * 6. Click on Find Oppurtunites using Xpath Locator	 * 
	 * 7. Get the List of Oppurtunites available in Oppurtunity id usinf Xpath Locator	 * 
	 * 8. Get the Title of the Page and verify it.
	 */

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
		WebDriverManager.chromiumdriver().setup();	
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//Launch the URL	
		driver.get("http://leaftaps.com/opentaps/control/login");
		System.out.println("The Leaftaps applicaiton launched sucessfully");
		
		//maximize the window
		driver.manage().window().maximize();
		
		//Enter UserName and Password Using Xpath Locator	
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoSalesManager");	
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		System.out.println("Entered User Name and Password");
		
				
		//Click on Login Button using Xpath Locator
	    driver.findElement(By.xpath("//input[@value='Login']")).click();
	    System.out.println("Application login sucessfully");
	    
	  //get screenshot	
	  		File findopp = driver.getScreenshotAs(OutputType.FILE);
	  		FileUtils.copyFile(findopp, new File("./Screenshot/findOppor1.jpeg"));
	    
	    //Click on CRM/SFA Link	 * 
	    driver.findElement(By.linkText("CRM/SFA")).click();	
	    System.out.println("clicked on CRM/SFA link sucessfully");
	    
	    //Click on Oppurtunites Button
	    driver.findElement(By.linkText("Opportunities")).click();	    
	    System.out.println("Clicked on Opportunity tab");
	    
	    //Click on Find Oppurtunites using Xpath Locator
	    driver.findElement(By.xpath("//a[contains(text(),'Find Opportunities')]")).click();
	    System.out.println("Clicked on FindOpportunity option");
	    
	    // Get the List of Oppurtunites available in Oppurtunity id usinf Xpath Locator
	    List<WebElement> opporid = driver.findElements(By.xpath("//table[@class='x-grid3-row-table']//td[1]/div/a"));
	    //int oppsize = opporid.size();
	    System.out.println("The opportunity id's availble as below");
	    
	    for (WebElement opp : opporid) {	    	
	    	  	
	    	String listopporid = opp.getText();
	    	System.out.println(listopporid);
			
		}
	    
		  //get screenshot	
  		File findopp1 = driver.getScreenshotAs(OutputType.FILE);
  		FileUtils.copyFile(findopp1, new File("./Screenshot/findOppor2.jpeg"));
	    
	    //Get the Title of the Page and verify it.
	    
	   	String title = driver.getTitle();
	   	System.out.println(title);
	   	
	   	if (title.contains("Find Opportunities")) {
	     			
	   	System.out.println("The Title of the find opportunities page is displayed as expected: " + title );  
	}
	   	
		//Close the chrome
		driver.close();
		System.out.println("Browser Closed sucessfully");	

	}

}
