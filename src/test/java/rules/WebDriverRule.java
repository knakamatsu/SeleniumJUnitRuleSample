package rules;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class WebDriverRule extends ExternalResource {

	WebDriver driver;
	public WebDriver getDriver() {
		return getInstance();
	}

	@Override
	protected void after() {
		this.driver.quit();
	}

	private WebDriver getInstance(){
		if(this.driver == null){
			ChromeDriverManager.getInstance().setup();
			this.driver = new ChromeDriver();
		}
		return driver;
	}
}
