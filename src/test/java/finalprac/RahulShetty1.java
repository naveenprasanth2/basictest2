package finalprac;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class RahulShetty1 {
	WebDriver driver;

	@Test
	public void test() throws IOException  {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		ChromeOptions co = new ChromeOptions();
		co.addArguments("headless");
		co.merge(dc);

		driver = new ChromeDriver(co);
//		SoftAssert soft = new SoftAssert();
//
		driver.get("https://untrusted-root.badssl.com/");
//		ArrayList<String> list = new ArrayList<String>();
//		list.add("Raymond");
//		list.add("Smith");
//		List<WebElement> tablevalues = driver.findElements(By.xpath("//div[@class='tableFixHead'] //td[1]"));
//		for (WebElement tablevalue : tablevalues) {
//			if (list.contains(tablevalue.getText())) {
//				System.out.println(tablevalue.findElement(By.xpath("following-sibling::td[3]")).getText());
//			}
//		}

		TakesScreenshot sc = (TakesScreenshot) driver;
		File src = sc.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src ,  new File("D:\\test.png"));

	}

}