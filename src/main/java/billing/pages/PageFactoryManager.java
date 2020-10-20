package billing.pages;

import org.openqa.selenium.WebDriver;

public class PageFactoryManager {

	private static LoginPagePO loginPage;
	
	
	public static LoginPagePO getLoginPage(WebDriver driver_) {
		if (loginPage == null) {
			return new LoginPagePO(driver_);
		}
		return loginPage;
	}

	
}
