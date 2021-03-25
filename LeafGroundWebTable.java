package Week2;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundWebTable {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
	WebDriverManager.chromiumdriver().setup();	
	ChromeDriver driver = new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
	//Launch the URL	
	driver.get("http://leafground.com/pages/table.html");
	
	//maximize the window
	driver.manage().window().maximize();
	
	//get the number row count value
	List<WebElement> rowcount = driver.findElements(By.xpath("//table[@id='table_id']//tr"));
	int rows = rowcount.size();
	System.out.println("The Number of row is : " + rows );
	
	//get the number of coloumn values
	List<WebElement> coloumncount = driver.findElements(By.xpath("//table[@id='table_id']//th"));
	int col = coloumncount.size();
	System.out.println("The Number of coloumn is : " + col );
	
	//get the progress value of "learn with interact Element"
	
	WebElement progress = driver.findElement(By.xpath("//table[@id='table_id']//tr[3]//td[2]"));
	String progpercentage = progress.getText();
	System.out.println("The Progress of the Learn with interact Element % is : " + progpercentage);
	
	//find the least completed progress and check the vital task checkbox.
	
	List<WebElement> progresslist  = driver.findElements(By.xpath("//table[@id='table_id']//tr//td[2]"));
	String [] prosvalue =new String[progresslist.size()];	
	int i=0;
	//int [] result = new int [10];
	
	List<Integer> result = new ArrayList<Integer>();
	
	//Storing List prosvaluelements text into String array
	for(WebElement a: progresslist)
	{
		prosvalue[i]=a.getText();		
		String replace	= prosvalue[i].replace("%","");
		int num = Integer.parseInt(replace);
		result.add(num);
		//System.out.println(num);
	i++;	
	}
	Collections.sort(result);
	Integer minValue = Collections.min(result);
	System.out.println(minValue);
	driver.findElement(By.xpath("//td[contains(text(),'"+minValue+"%')]/following-sibling::td/input")).click(); 
	System.out.println("The min Value check box is checked sucessfully");
	
	
	//get screenshot	
	File snapshot = driver.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(snapshot, new File ("./Screenshot/Screenshot1.jpeg"));
	
	
	//get mentor name	
	List<WebElement> mentorname = driver.findElements(By.xpath("//table[@id='table_id']//tr//td[5]"));
	
	for (WebElement name : mentorname) {
		
		System.out.println(name.getText());		
		
	}
	
	
	

	}

}
