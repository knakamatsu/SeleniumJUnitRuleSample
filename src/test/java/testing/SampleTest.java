package testing;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import rules.WebDriverRule;

@RunWith(Enclosed.class)
public class SampleTest {

	public static class methodSample {
		@Rule
		public WebDriverRule dr = new WebDriverRule();

		@Test
		public void test(){
			seleniumTest(dr.getDriver(), "Software Test.");
		}

		@Test
		public void test2(){
			seleniumTest(dr.getDriver(), "Selenium Test.");
		}

		@Test
		public void test3(){
			seleniumTest(dr.getDriver(), "Chrome Test.");
		}
	}

	public static class classSample {
		@ClassRule
		public static WebDriverRule dr = new WebDriverRule();

		@Test
		public void test(){
			seleniumTest(dr.getDriver(), "Software Test.");
		}

		@Test
		public void test2(){
			seleniumTest(dr.getDriver(), "Selenium Test.");
		}

		@Test
		public void test3(){
			seleniumTest(dr.getDriver(), "Chrome Test.");
		}
	}

	public static void seleniumTest(WebDriver d ,String input) {
		d.get("https://www.google.co.jp/");
		WebElement el = d.findElement(By.cssSelector("input[aria-label='検索']"));
		el.sendKeys("chrome test.");
		el.sendKeys(Keys.ENTER);
		try { Thread.sleep(500); } catch (InterruptedException e) {}
	}
}
