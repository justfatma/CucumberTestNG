package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinition{

	 WebDriver driver;

	
	 @Given("^user is already on Login Page$")
	 public void user_already_on_login_page(){
		// System.setProperty("webdriver.chrome.driver","C:\\Users\\Selenium\\Chrome Driver\\chromedriver.exe");
//		 driver = new ChromeDriver();
		 System.setProperty("webdriver.gecko.driver","C:\\Users\\Selenium\\Gecko Driver\\geckodriver.exe");
		 driver = new FirefoxDriver();
		 driver.get("https://www.freecrm.com/index.html");
	 }
	
	
	 @When("^title of login page is Free CRM$")
	 public void title_of_login_page_is_free_CRM(){
		 String title = driver.getTitle();
		 System.out.println(title);
		 Assert.assertEquals(title,"#1 Free CRM customer relationship management software cloud" );
	 }
	
	 //Reg Exp:
	 //1. \"([^\"]*)\"
	 //2. \"(.*)\"
	
	 @Then("^user enters \"(.*)\" and \"(.*)\"$")
	 public void user_enters_username_and_password(String username, String password) throws InterruptedException{
		 Thread.sleep(3000);
		 driver.findElement(By.cssSelector(".btn.btn-primary.btn-xs-2.btn-shadow.btn-rect.btn-icon.btn-icon-left")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//input[@type='text' and @name='email']")).sendKeys(username);
		 driver.findElement(By.xpath("//input[@type='password' and @name='password']")).sendKeys(password);
	 }
	
	 @Then("^user clicks on login button$")
	 public void user_clicks_on_login_button() {
		 WebElement loginBtn = driver.findElement(By.cssSelector(".ui.fluid.large.blue.submit.button"));
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click();", loginBtn);
	 }
	
	
	 @Then("^user is on home page$")
	 public void user_is_on_hopme_page(){
		 String title = driver.getTitle();
		 System.out.println("Home Page title :"+ title);
	     Assert.assertEquals(title, "Cogmento CRM");
	 }
	 
	 @Then("^user moves to new contact page$")
	 public void user_moves_to_new_contact_page() throws InterruptedException {
		//driver.switchTo().frame("mainpanel");
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		action.moveToElement(driver.findElement(By.cssSelector(".users.icon"))).build().perform();
		driver.findElement(By.cssSelector("div#main-nav div:nth-of-type(3) button")).click();
		action.moveByOffset(250,200).build().perform();
		Thread.sleep(2000);
		}
	 
	 
	 @Then("^user enters contact details \"(.*)\" and \"(.*)\"$")
	 public void user_enters_contacts_details(String firstname, String lastname){
		 driver.findElement(By.xpath("//input[@type='text' and @name='first_name']")).sendKeys(firstname);
		 driver.findElement(By.xpath("//input[@type='text' and @name='last_name']")).sendKeys(lastname);
		 driver.findElement(By.cssSelector(".save.icon")).click();
	 }
	 

	 @Then("^Close the browser$")
	 public void close_the_browser(){
		 driver.quit();
	 }
	
	
	

}
