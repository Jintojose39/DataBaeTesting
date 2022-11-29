import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

;

public class jdbConnection {

	public static void main(String[] args) throws SQLException {

		String host = "localhost";

		String port = "3306";

		Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/demo", "root",
				"Jintojose@1996");

		Statement s = con.createStatement();

		ResultSet rs = s.executeQuery("Select * From EmployeeInfo Where age=21;");

		while (rs.next()) {

			WebDriver driver = new FirefoxDriver();

			driver.get("https://login.salesforce.com/?locale=in");

			driver.manage().window().maximize();

			driver.findElement(By.xpath("//input[@id='username']")).sendKeys(rs.getString("location"));

			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(rs.getString("name"));

			System.out.println(rs.getString("location"));

			System.out.println(rs.getString("name"));

			System.out.println(rs.getInt("age"));
			
			driver.close();

		}
	}

}
