package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.homePageFactory;
import pageFactory.loginPageFactory;

public class PageFactoryLoginLoginStepsDefinition {

	static WebDriver driver;
	loginPageFactory login;
	homePageFactory home;

	@Given("User is on login")
	public void user_is_on_login() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.saucedemo.com/");

	}

	/*
	 * @When("User enters valid username and password") public void
	 * user_enters_valid_username_and_password() {
	 * driver.findElement(By.id("user-name")).sendKeys("standard_user");
	 * driver.findElement(By.id("password")).sendKeys("secret_sauce"); }
	 */

	@When("User enters valid {string} and {string}")
	public void user_enters_valid_and(String username, String password) {
		
		login = new loginPageFactory(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		
		//driver.findElement(By.id("user-name")).sendKeys(username);
	//	driver.findElement(By.id("password")).sendKeys(password);
	}

	@And("Clicks on Login Button")
	public void clicks_on_login_button() 
	{
		login.clickOnLoginButton();
		//driver.findElement(By.id("login-button")).click();
	}

	@Then("User is navigated to Home Page")
	public void user_is_navigated_to_home_page() {
		
		home=new homePageFactory(driver);
		home.isCartDisplayed();
		//Assert.assertTrue(driver.findElements(By.xpath("//div[@class='app_logo']")).size() > 0,
			//	"User is navigated to Home Page");
	}

	@And("Close the browser")
	public void close_the_browser() {
		driver.close();
	}

}
