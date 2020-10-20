package billing_payment.script;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import billing.pages.*;

public class TestScript_1 extends AbstractTest {
	private WebDriver driver;
	private LoginPagePO loginPage;

	@Parameters({ "browser", "authenuser", "authenpass", "url", "version" })
	@BeforeClass
	public void beforeClass(String browser, String authenuser, String authenpass, String url, String version) {
		driver = openMultiBrowser(browser, authenuser, authenpass, url, version);
		loginPage = PageFactoryManager.getLoginPage(driver);

	}

	@Test
	public void TC_01_CheckLoginWithValidAccount() throws Exception {
		loginPage.sleepInSeconds(2);
		loginPage.getCoreUserList();
		loginPage.sleepInSeconds(6);
	}

	@Parameters({ "browser" })
	@AfterClass
	public void afterClass(String browser) {
		closeBrowser(driver, browser);
		closeConnectDB();
	}

}
