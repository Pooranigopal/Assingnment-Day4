package Week2;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundDropDown {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
	WebDriverManager.chromiumdriver().setup();	
	ChromeDriver driver = new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
	//Launch the URL	
	driver.get("http://www.leafground.com/pages/Dropdown.html");
	
	//maximize the window
	driver.manage().window().maximize();
	
	//Select training program by index"
	
	WebElement prog = driver.findElement(By.id("dropdown1"));	
	Select dd1 = new Select(prog);
	dd1.selectByIndex(1);	
	System.out.println("The 'Selenium' is selected");
	
	//Select training program by Text
	WebElement prog1 = driver.findElement(By.name("dropdown2"));
	Select dd2 = new Select(prog1);
	dd2.selectByVisibleText("Appium");
	System.out.println("The 'Appium' is selected");
	
	//Select training program by Value
	WebElement prog2 = driver.findElement(By.id("dropdown3"));
	Select dd3 = new Select(prog2);
	dd3.selectByValue("3");;
	System.out.println("The 'UFT/QTP' is selected");
	
	
	//get the numbers dropdown by option	
	List<WebElement> getnumdd = driver.findElements(By.xpath("//div[@class='example'][4]//select//option"));
	System.out.println("The Number of dropdown is : " +(getnumdd.size()-1));
	
		
	//use sendkeys to select	
	WebElement selpro = driver.findElement(By.xpath("//div[@class='example'][5]//select//option[5]"));
	selpro.click();
	System.out.println("The 'Loadrunner' is selected");
		
	//Select program	
	WebElement selectprog = driver.findElement(By.xpath("//section[@class='innerblock']//div[6]//option[4]"));	
	selectprog.click();	
	System.out.println(selectprog.isSelected());
	
	//get screenshot	
		File snapshot = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(snapshot, new File("./Screenshot/Screenshot2.jpeg"));


	
		


	}

}
