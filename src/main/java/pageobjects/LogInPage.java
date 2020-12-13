package pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
	private WebDriver webDriver;

	public LogInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		webDriver = driver;
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Login')]")
	private WebElement loginLink;
	@FindBy(how = How.ID, using = "userName")
	private WebElement userId;
	@FindBy(how = How.ID, using = "exampleInputPassword1")
	private WebElement password;
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Submit')]")
	private WebElement loginBtn;
	@FindBy(how = How.XPATH, using = "(//div[contains(@class,'navbar')])[1]//li/a")
	private List<WebElement> navmenu;

	public void setCredential(String username, String pwd) {
		loginLink.click();
		userId.sendKeys(username);
		password.sendKeys(pwd);
	}

	public void login() {
		loginBtn.click();
	}

	public String getTitle() {
		return webDriver.getTitle();
	}

	public List<String> getNavMenus() {
		List<String> navMenuName = new ArrayList<String>();
		for (WebElement w : navmenu) {
			String s = w.getText();
			navMenuName.add(s);
		}
		return navMenuName;
	}
}
