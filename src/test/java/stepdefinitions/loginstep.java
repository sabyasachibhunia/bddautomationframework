package stepdefinitions;

import static org.junit.Assert.assertEquals;

import helpers.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.LogInPage;

public class loginstep {
	TestContext testContext;
	LogInPage logInPage;

	public loginstep(TestContext context) {
		testContext = context;
		logInPage = testContext.getPageObjectManager().getLogInPage();
	}

	@Given("^I am an admin with (.+) and (.+)$")
	public void i_am_an_admin_with_usedid_and_password(String userid, String password) throws Throwable {
		logInPage.setCredential(userid, password);
	}

	@When("^I click on login button$")
	public void i_click_on_login_button() throws Throwable {
		logInPage.login();
	}

	@Then("^I logged into the dashboard$")
	public void i_logged_into_the_dashboard() throws Throwable {
		String expectedTitle = logInPage.getTitle();
		assertEquals("Login", expectedTitle);
	}

	@And("^I verify the navigation menus$")
	public void i_verify_the_navigation_menus() throws Throwable {
		String navigationmenu1 = logInPage.getNavMenus().get(0);
		String navigationmenu2 = logInPage.getNavMenus().get(1);
		String navigationmenu3 = logInPage.getNavMenus().get(2);
		assertEquals("Home", navigationmenu1);
		assertEquals("Blog", navigationmenu2);
		assertEquals("How It Works", navigationmenu3);
	}

}
