package finalprac;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Popupscreen {
	
	static WebDriver driver;
	static WebDriverWait wait;
	public static void main(String[] args) throws HeadlessException, AWTException, IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");
		String screenpath = System.getProperty("user.dir")+"\\src\\main\\java\\screenshots";
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://qavbox.github.io/demo/alerts/");
		wait = new WebDriverWait(driver, 5);
		driver.findElement(By.name("commit")).click();
		
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		
		BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
	    ImageIO.write(image, "jpg", new File(screenpath+"\\alert.jpg"));
	    
	    alert.accept();
		driver.quit();
	}
}