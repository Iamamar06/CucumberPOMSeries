package stepdefinitions;

import java.util.List;

import org.junit.Assert;

import com.pages.HomePage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

public class HomePageStepdef {

	private HomePage homePage = new HomePage(DriverFactory.getDriver());

	@Then("I verify {string} content has {int} page links")
	public void i_verify_content_has_page_links(String whichPartOfThePage, Integer expectedCount) {
		Assert.assertTrue(
				"Not matching: Expected [" + expectedCount + "] Actual [" + homePage.getCountOfElements(whichPartOfThePage) + "]",
				homePage.getCountOfElements(whichPartOfThePage) == expectedCount);
	}

	@Then("I verify that {string} has following pages")
	public void i_verify_that_has_following_pages(String whichPartOfThePage, DataTable dataTable) {
		List<String> expectedList = dataTable.asList();
		System.out.println("Expected " + whichPartOfThePage + " pages list: " + expectedList);
		List<String> actualList = homePage.getListofGivenElements(whichPartOfThePage);
		System.out.println("Actual   " + whichPartOfThePage + " pages list: " + actualList);

		Assert.assertEquals("The lists do not match", expectedList, actualList);
	}
}
