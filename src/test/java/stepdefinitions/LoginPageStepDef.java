package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.utils.ConfigReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStepDef {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	String title;
	ConfigReader reader = new ConfigReader();
	String URL = reader.init_prop().getProperty("magentoLoginuURL");

	@Given("I am on login page of magento application")
	public void i_am_on_login_page_of_magento_application() {
		String URL = reader.init_prop().getProperty("magentoLoginuURL");
		DriverFactory.getDriver().get(URL);
	}

	@When("I get the title of the current page")
	public void i_get_the_title_of_the_login_page() {
		title = loginPage.getPageTitle();
		System.out.println(title);
	}

	@Then("I verify title of the page is {string}")
	public void i_verify_title_of_the_page_is(String expectedTitle) {
		Assert.assertTrue(title.contains(expectedTitle));
	}

	@When("I enter user name {string} and password {string}")
	public void i_enter_user_name_and_password(String email, String password) {
		loginPage.enterUsernameAndPassword(email, password);
	}

	@When("I click on {string} button")
	public void i_click_on_button(String string) {
		loginPage.clickOnSignInButton();
	}

	@Then("I verify that {string} page is loaded")
	public void i_verify_that_page_is_loaded(String string) {

	}

	@Then("I verify that error message is displayed for invalid credentials")
	public void i_verify_that_error_message_is_displayed_for_invalid_credentials() {
		String errorMessage = loginPage.verifyErrorMessageIsDisplayedForInvalidCreds();
		Assert.assertTrue("Error message is not displayed", errorMessage.contains("account sign-in was incorrect"));
	}

	@Given("I verify that forgot your password link is displayed")
	public void i_verify_that_forgot_your_password_link_is_displayed() {
		Assert.assertTrue("Forgot_your_password link is not displayed", loginPage.verifyForgotYourpasswordLinkIsDisplayed());
	}

	@When("I clik on forgot your password link")
	public void i_clik_on_forgot_your_password_link() {
		loginPage.clickOnForgotPasswordLink();
	}
	
	@Given("I login to magento app using below credentials")
	public void i_login_to_magento_app_using_below_credentials(DataTable dataTable) {	
		List<Map<String, String>> creds = dataTable.asMaps();
		String username = creds.get(0).get("username");
		String pass = creds.get(0).get("password");
		
		DriverFactory.getDriver().get(URL);
		loginPage.enterUsernameAndPassword(username, pass);
		loginPage.clickOnSignInButton();
		
	}
}
