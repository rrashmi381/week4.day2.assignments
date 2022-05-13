package week4.day2.assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://www.leafground.com/pages/Dropdown.html");

		WebElement Index = driver.findElement(By.id("dropdown1"));
		Select select = new Select(Index);
		select.selectByIndex(1);

		WebElement Text = driver.findElement(By.name("dropdown2"));
		Select select1 = new Select(Text);
		select1.selectByVisibleText("Appium");

		WebElement Value = driver.findElement(By.id("dropdown3"));
		Select select2 = new Select(Value);
		select2.selectByValue("3");

		WebElement Options = driver.findElement(By.className("dropdown"));
		Select select3 = new Select(Options);
		List<WebElement> options1 = select3.getOptions();
		select3.selectByIndex(options1.size() - 1);
		int num = options1.size();
		System.out.println('\n' + "Total number of the dropdown options : " + num + '\n');
		for (WebElement eachOptions1 : options1) {
			System.out.println(eachOptions1.getText());
		}

		driver.findElement(By.xpath("//div[@id='contentblock']/section[1]/div[5]/select[1]")).sendKeys("Selenium");

		WebElement index1 = driver.findElement(By.xpath("//div[@id='contentblock']/section[1]/div[6]/select[1]"));
		Select select4 = new Select(index1);
		select4.selectByIndex(1);
		select4.selectByIndex(2);
		select4.selectByIndex(3);
		select4.selectByIndex(4);
	}
}
