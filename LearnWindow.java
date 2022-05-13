package week4.day2.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class LearnWindow {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.findElement(By.id("home")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);

		List<String> windowHandlesList = new ArrayList<String>(windowHandles);
		String newWindowHandle = windowHandlesList.get(1);
		driver.switchTo().window(newWindowHandle);
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		System.out.println("--------------------------------------------------");
		driver.switchTo().window(windowHandlesList.get(0));
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
	}
}
