import org.junit.Test;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertEquals;

public class SimpleJUnitTest
{
	@Test
	public void testGetTitle() throws MalformedURLException
	{
		String username = System.getenv("SAUCE_USERNAME");
		String accessKey = System.getenv("SAUCE_ACCESS_KEY");

		System.out.println("\nSetting Capabilities.");

		ChromeOptions chromeOpts = new ChromeOptions();
		chromeOpts.setExperimentalOption("w3c", true);

		MutableCapabilities sauceOpts = new MutableCapabilities();
		sauceOpts.setCapability("seleniumVersion", "3.11.0");
		sauceOpts.setCapability("user", username);
		sauceOpts.setCapability("accessKey", accessKey);
		sauceOpts.setCapability("name", "Selenium_4_test with JUnit");

		MutableCapabilities caps = new MutableCapabilities();
		caps.setCapability(ChromeOptions.CAPABILITY, chromeOpts);
		caps.setCapability("platformName", "Windows 8.1");
		caps.setCapability("browserVersion", "77.0");
		caps.setCapability("sauce:options", sauceOpts);
		caps.setCapability("goog:chromeOptions", chromeOpts);

		String sauceUrl = "https://" + username + ":" + accessKey + "@ondemand.saucelabs.com/wd/hub";

		URL url = new URL(sauceUrl);
		RemoteWebDriver driver = new RemoteWebDriver(url, caps);

		System.out.println("Starting driver get title test.");
		driver.navigate().to("https://www.saucedemo.com");
		String title = driver.getTitle();

		assertEquals("Swag Labs", title);

		driver.quit();
	}
}
