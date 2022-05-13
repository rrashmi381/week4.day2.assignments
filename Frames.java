package week4.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Frames {
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.switchTo().frame("frame1");
		driver.findElement(By.tagName("input")).sendKeys("Cat");
		driver.switchTo().frame("frame3");
		driver.findElement(By.tagName("input")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");
		WebElement Index = driver.findElement(By.tagName("select"));
		Select select = new Select(Index);
		select.selectByIndex(2);
		driver.switchTo().defaultContent();
	}

}
