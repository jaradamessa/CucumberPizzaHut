package stepDefs;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderDefs {

	WebDriver driver = BaseClass.driver;

	@Given("I have launched the application")
	public void i_have_launched_the_application() {
		driver.get("https://www.pizzahut.co.in/");
	}

	@When("I enter the location as {string}")
	public void i_enter_the_location_as(String string) {
		WebElement Location = driver.findElement(By.xpath("//input[@placeholder='Enter your location for delivery']"));
		Location.sendKeys("Pune");

	}

	@When("I select the very first suggestion from the list")
	public void i_select_the_very_first_suggestion_from_the_list() throws InterruptedException {

		WebElement Place = driver.findElement(By.xpath("//*[contains(text(),'Pune Railway Station')]"));
		Place.click();
		Thread.sleep(5000);

	}

	@Then("I should land on the Deals page")
	public void i_should_land_on_the_Deals_page() {
		WebElement Deals = driver.findElement(By.xpath("//a[@data-synth='link--deals--side']//span[text()='Deals']"));
		Assert.assertTrue(Deals.isDisplayed());
	}

	@Then("I select the tab as {string}")
	public void i_select_the_tab_as(String links) {
		WebElement Tabs = driver.findElement(By.xpath("//a[@data-synth='link--pizzas--side']//span[text()='Pizzas']"));
		Tabs.click();
	}

	@Then("I select the pizza as {string}")
	public void i_select_the_pizza_as(String menu) {

		WebElement MyPizza = driver
				.findElement(By.xpath("//div[text()='" + menu + "']//following::span[text()='Add'][1]"));
		MyPizza.click();

	}

	@Then("I should see the pizza is added to the cart")
	public void i_should_see_the_pizza_is_added_to_the_cart() {
		WebElement BaseketItem = driver.findElement(By.xpath(
				"//div[@data-testid='basket-item-product']//div[contains(text(),'Personal Schezwan Margherita')]"));
		Assert.assertTrue(BaseketItem.isDisplayed());
	}

	@Then("I click on the Checkout button")
	public void i_click_on_the_Checkout_button() {
		WebElement Checkout = driver.findElement(By.xpath("//div[@class='basket-checkout']//a"));
		Checkout.click();

	}

	@Then("I should be landed on the secured checkout page")
	public void i_should_be_landed_on_the_secured_checkout_page() {
		WebElement checkoutPage = driver.findElement(By.xpath("//span[text()='Secure Checkout']"));
		Assert.assertEquals(checkoutPage.getText(), "Secure Checkout");

	}

	@Then("I enter the personal details")
	public void i_enter_the_personal_details(DataTable dataTable) {
		List<List<String>> userList = dataTable.asLists(String.class);
		for (List<String> e : userList) {
			WebElement personalDetails = driver
					.findElement(By.xpath("(//div[contains(@class,'typography-6')]" + e ));	
			personalDetails.click();
			}
	}

	@Then("I enter the address details")
	public void i_enter_the_address_details(DataTable dataTable) {
		List<List<String>> userList = dataTable.asLists(String.class);
		for (List<String> e : userList) {
			WebElement deliveryAddress = driver
					.findElement(By.xpath("(//input[@id='checkout__deliveryAddress.interior']" + e + "']"));	
			deliveryAddress .click();
			}

	}

	@Then("I should see three payment options")
	public void i_should_see_three_payment_options(List<String> Options) {
		for (String option : Options) {

			WebElement paymentOption = driver
					.findElement(By.xpath("(//div[contains(@class,'form-section')])[5]" + option + "']"));
			Assert.assertTrue(paymentOption.isDisplayed());
		}
	}

	@Then("I select the payment option as {string}")
	public void i_select_the_payment_option_as(String paymentType) {
		// Write code here that turns the phrase above into concrete actions
		WebElement cashButton = driver.findElement(By.xpath("//input[@data-synth='payment-method--cash']"));
		cashButton.click();

	}

}