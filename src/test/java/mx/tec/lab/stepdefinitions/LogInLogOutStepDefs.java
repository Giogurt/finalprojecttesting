package mx.tec.lab.stepdefinitions;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogInLogOutStepDefs {
    private static WebDriver driver;
	
	@Given("the user is on the login page")
	public void the_user_is_on_the_login_page() {
		String basePath = new File("").getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", basePath + "\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/login");
	}
	
	@When("she fills in {string} with {string}")
	public void she_fills_in_with(String inputId, String inputValue) {
	    WebElement usernameField = driver.findElement(By.id(inputId));
	    usernameField.sendKeys(inputValue);
	}

	@When("And she fills in {string} with {string}")
	public void she_fills_in_password_with(String passId, String passValue) {
	    WebElement passwordField = driver.findElement(By.id(passId));
	    passwordField.sendKeys(passValue);
	}
	
	@When("she presses {string}")
	public void she_presses(String buttonName) {
	    WebElement submitButton = driver.findElement(By.className(buttonName));
	    submitButton.click();
	}
	
	@Then("she is redirected to the next page")
	public void she_is_redirected() {
		WebElement headerLabel = driver.findElement(By.tagName("h2"));
		String title = headerLabel.getText();
		if (title == "Login Page") {
			assertEquals("Login Page", title);
		} else if (title == "Secure Area") {
			assertEquals("Secure Area", title);
		}
	}

	@Then("she sees {string}")
	public void she_sees(String successMessage) {
		WebElement divSuccess = driver.findElement(By.id("flash"));
		String text = divSuccess.getText();
		assertThat(text, containsString(successMessage));
		driver.close();
	}
	
//	@Then("she sees {string}")
//	public void she_sees_error(String errorMessage) {
//		WebElement divError = driver.findElement(By.id("flash"));
//		String text = divError.getText();
//		assertThat(text, containsString(errorMessage));
//		driver.close();
//	}
}
