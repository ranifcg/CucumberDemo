package stepDefinition;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestSteps {
	
WebDriver driver;
String exp_title = "Adactin.com - Search Hotel";
String exp_greeting = "Hello raniselen!";

@Given("user is on the login page")
public void user_is_on_the_login_page() {
    // Write code here that turns the phrase above into concrete actions
	System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver\\chromedriver.exe");
	//System.setProperty("webdriver.edge.driver", "C:\\Drivers\\edgedriver_win64\\msedgedriver.exe");
	//System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver-v0.32.0-win64\\geckodriver.exe");

	driver = new ChromeDriver();
	driver.get("http://adactinhotelapp.com");


	driver.manage().window().maximize();
}

@When("user enters user name and password")
public void user_enters_user_name_and_password()  {
    // Write code here that turns the phrase above into concrete actions
	
	WebElement uName = driver.findElement(By.id("username"));
	
	uName.sendKeys("raniselen");
	
	driver.findElement(By.id("password")).sendKeys("adactin");
	
}

// from feature file it picks up username and password
@When("user enters \"(.*)\", \"(.*)\"$")
public void user_enters(String username, String password)  {
	WebElement uName = driver.findElement(By.id("username"));
	
	uName.sendKeys(username);
	driver.findElement(By.id("password")).sendKeys(password);

}

@When("user clicks on login button")
public void user_clicks_on_login_button() throws Exception {
    // Write code here that turns the phrase above into concrete actions
	
	driver.findElement(By.cssSelector("input#login")).click();
}


@Then("Login is succesful")
public void login_is_succesful() throws InterruptedException {
    // Write code here that turns the phrase above into concrete actions
	
	String curr_greeting = driver.findElement(By.id("username_show")).getAttribute("value");
	System.out.println(curr_greeting);
	
	assertEquals(exp_greeting, curr_greeting);
}

@Then("Search Page is displayed")
public void search_page_is_displayed() throws InterruptedException {
    // Write code here that turns the phrase above into concrete actions
	String curr_title = driver.getTitle();
	System.out.println(curr_title);
	driver.quit();
	
	assertEquals(exp_title, curr_title);	
}




@When("login is succesful")
public void login_is_succesful1() {
	String curr_greeting = driver.findElement(By.id("username_show")).getAttribute("value");
	System.out.println(curr_greeting);
}

@When("search Page is displayed")
public void search_page_is_displayed1() {
	String curr_title = driver.getTitle();
	System.out.println(curr_title);
}

@When("user selects \"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\"$")
public void user_selects(String location, String roomno, String checkin, String checkout, String adults) {
	 //Drop down  to select LOCATION
    new Select(driver.findElement(By.className("search_combobox"))).selectByValue(location);


    //Drop down to select Number of Rooms
     new Select(driver.findElement(By.id("room_nos"))).selectByValue(roomno);

     //Date picker-Enter check in date
     WebElement checkinDate = driver.findElement(By.id("datepick_in"));
     checkinDate.clear();
     checkinDate.sendKeys(checkin);

     //Date picker-Enter checkout date
     WebElement checkoutDate = driver.findElement(By.id("datepick_out"));
     checkoutDate.clear();
     checkoutDate.sendKeys(checkout);

     //Select Adults per room
     new Select(driver.findElement(By.id("adult_room"))).selectByValue(adults);
}

@When("user clicks on Search button")
public void user_clicks_on_search_button() {
    // Write code here that turns the phrase above into concrete actions
	 //Click on Search
    driver.findElement(By.id("Submit")).click();}

@When("search results are displayed")
public void search_results_are_displayed() {
    // Write code here that turns the phrase above into concrete actions
	System.out.println("Successful search page" + driver.getTitle());

}

@Then("search results should be displayed")
public void search_results_should_be_displayed() {
    // Write code here that turns the phrase above into concrete actions
	System.out.println("Successful search page");
	String curr_title = driver.getTitle();
	exp_title = "Adactin.com - Select Hotel";
	driver.quit();
	assertEquals(exp_title, curr_title);
}

@When("user clicks hotel")
public void user_clicks_hotel() {
    // Write code here that turns the phrase above into concrete actions
	driver.findElement(By.id("radiobutton_1")).click();
	driver.findElement(By.id("continue")).click();
}

@When("enter details is displayed")
public void enter_details_is_displayed() {
    // Write code here that turns the phrase above into concrete actions
	System.out.println("Successful search page" + driver.getTitle());
}

@When("user enters details \"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\"$")
public void user_enters_details(String fname, String lname, String add, String ccno, String cctype, String expmonth, String expyear, String cvv ) {
	 System.out.println("inside enter details");
	
	JavascriptExecutor executorjs = (JavascriptExecutor) driver;
	executorjs.executeScript("window.scrollBy(0,500)");
	
	driver.findElement(By.id("first_name")).sendKeys(fname);
	driver.findElement(By.id("last_name")).sendKeys(lname);
	driver.findElement(By.id("address")).sendKeys(add);
	driver.findElement(By.id("cc_num")).sendKeys(ccno);
    new Select(driver.findElement(By.id("cc_type"))).selectByValue(cctype);
    new Select(driver.findElement(By.id("cc_exp_month"))).selectByIndex(Integer.valueOf(expmonth));
    new Select(driver.findElement(By.id("cc_exp_year"))).selectByIndex(Integer.valueOf(expyear));
    driver.findElement(By.id("cc_cvv")).sendKeys(cvv);
     
}


@When("user clicks on Submit button")
public void user_clicks_on_submit_button() {
    driver.findElement(By.id("book_now")).click();

}

@When("booking confirmation displayed")
public void booking_confirmation_displayed() {
    // Write code here that turns the phrase above into concrete actions
	System.out.println("Booking confirmed. " + driver.getTitle());
}

@When("user clicks on MyItenary button")
public void user_clicks_on_my_itenary_button() throws Exception {
	JavascriptExecutor executorjs = (JavascriptExecutor) driver;
	executorjs.executeScript("window.scrollBy(0,500)");
	Thread.sleep(5000);
    // Write code here that turns the phrase above into concrete actions
	driver.findElement(By.id("my_itinerary")).click();
	
	
}

@Then("itenary displayed")
public void itenary_displayed() throws Exception {
    // Write code here that turns the phrase above into concrete actions
	System.out.println("Displaying my itenary on page: . " + driver.getTitle());
	String expurl = "http://adactinhotelapp.com/BookedItinerary.php";
	String acturl = driver.getCurrentUrl();
	Thread.sleep(3000);
	driver.quit();
	assertEquals(expurl, acturl);
}


@Given("This is a blank test")
public void this_is_a_blank_test() {

	System.out.println("Check blank test");
}


}
