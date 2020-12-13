package pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BlogPage {
	public BlogPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "((//div[contains(@class,'navbar')])[1]//a)[2]")
	private WebElement blogLink;
	@FindBy(how = How.XPATH, using = "//main[@class='pb-3']//h3")
	private List<WebElement> blogsList;

	public void clickOnBlog() {
		blogLink.click();
	}

	public List<String> getAllBlogs() {
		List<String> blogs = new ArrayList<String>();
		for (WebElement w : blogsList) {
			String s = w.getText();
			blogs.add(s);
		}
		return blogs;
	}
}
