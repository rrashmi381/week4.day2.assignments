package week4.day2.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Amazon {
	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(" https://www.amazon.in/ ");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(" oneplus 9 pro", Keys.ENTER);
		String text = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		System.out.println('\n' + "1. The price of the first product is : " + text);

		List<WebElement> list = driver.findElements(By.xpath("(//span[@class='a-price-whole'])[1]"));
		List<String> price = new ArrayList<String>();
		for (WebElement Security : list) {
			price.add(Security.getText());
		}

		Set<String> set1 = new HashSet<String>();
		for (String i : price) {
			set1.add(i);
		}
		driver.findElement(By.xpath("(//i[@class='a-icon a-icon-popover'])[1]")).click();
		String text1 = driver
				.findElement(
						By.xpath("(//span[@class='a-size-medium a-color-base a-text-beside-button a-text-bold'])[1]"))
				.getText();
		System.out.println('\n' + "2. The number of customer ratings for the first displayed product : " + text1);

		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();

		driver.getWindowHandle();
		for (String nextpage : driver.getWindowHandles()) {
			driver.switchTo().window(nextpage);
		}
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File desgImage = new File("./snaps/IMG003.png");
		FileUtils.copyFile(screenshotAs, desgImage);
		driver.findElement(By.id("add-to-cart-button")).click();
		driver.findElement(
				By.xpath("(//span[@class='a-button a-button-base attach-button-large attach-cart-button'])[1]"))
				.click();
		String text2 = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[3]")).getText();
		System.out.println('\n' + "3. The cart subtotal : " + text2);

		List<WebElement> list1 = driver.findElements(By.xpath("(//span[@class='a-price-whole'])[3]"));
		List<String> price1 = new ArrayList<String>();
		for (WebElement Security : list1) {
			price1.add(Security.getText());
		}

		Set<String> set2 = new HashSet<String>();
		System.out.println('\n' + "4. Verification : " + '\n');
		for (String j : price1) {
			set2.add(j);
		}
		for (String cart : set1) {
			if (set2.contains(cart))
				System.out.println(
						"The price of the product and the subtotal of the product added in the cart is correct");
			else
				System.out.println(
						" The price of the product and the subtotal of the product added in the cart is not correct");
			// driver.close();
		}
	}
}

