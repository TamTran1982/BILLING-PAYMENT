package billing.pages;

import java.sql.ResultSet;
import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.Constants;

public class LoginPagePO extends AbstractPage {
	WebDriver driver;
	private String driverName = Constants.DRIVER_NAME;
	private String dbUrl = Constants.URL_DB;
	private String dbUserName = Constants.USER_DB;
	private String dbPassword = Constants.PASSWORD_DB;
	private String sql = "";
	private ResultSet rs;

	public LoginPagePO(WebDriver driver_) {
		this.driver = driver_;
		openDBConnection(driverName, dbUrl, dbUserName, dbPassword);
	}

	public void getCoreUserList() {
		try {
			String username, password;
			Integer n = 0;
			sql = "SELECT * FROM core_user";
			rs = runQuery(sql);
			System.out.println("User name : \tPassword : ");
			while (rs.next()) {
				username = rs.getString("username");
				password = rs.getString("password_hash");
				System.out.println(username + "\t \t" + password);
				n++;
			}
			System.out.println("Total records : " + n);

		} catch (

		Exception e) {
			System.out.println("Query execution error");
			e.printStackTrace();
		}
	}
}
