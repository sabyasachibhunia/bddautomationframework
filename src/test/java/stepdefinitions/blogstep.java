package stepdefinitions;

import static org.junit.Assert.assertTrue;
import java.util.List;
import helpers.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.BlogPage;

public class blogstep {
	TestContext testContext;
	BlogPage blogPage;

	public blogstep(TestContext context) {
		testContext = context;
		blogPage = testContext.getPageObjectManager().getBlogPage();
	}

	@When("^I click on blog menu$")
	public void i_click_on_blog_menu() throws Throwable {
		blogPage.clickOnBlog();
	}

	@Then("^I can see (.+) blogs$")
	public void i_can_see_Cybr_blogs(String blogName) throws Throwable {
		List<String> blogsHeading = blogPage.getAllBlogs();
		for (String s : blogsHeading) {
			assertTrue(s.contains(blogName));
		}
	}
}
