package helpers;

import org.openqa.selenium.WebDriver;

import pageobjects.BlogPage;
import pageobjects.LogInPage;

public class PageObjectManager {
	private WebDriver driver;
	private LogInPage logInPage;
	private BlogPage blogPage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public LogInPage getLogInPage() {
		return (logInPage == null) ? new LogInPage(driver) : logInPage;
	}

	public BlogPage getBlogPage() {
		return (blogPage == null) ? new BlogPage(driver) : blogPage;
	}
}
