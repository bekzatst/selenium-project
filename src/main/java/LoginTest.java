import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Objects;

public class LoginTest {
    private WebDriver driver;

    public LoginTest(String browser) {
        if (Objects.equals(browser, "chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win64\\chromedriver.exe");
            this.driver = new ChromeDriver();
        } else if (Objects.equals(browser, "edge")){
            System.setProperty("webdriver.edge.driver", "C:\\Users\\user\\Downloads\\edgedriver_win64\\msedgedriver.exe");
            this.driver = new EdgeDriver();
        }
    }

    @BeforeMethod
    public void setUp(){
        driver.get("file:C:///Users/user/Desktop/selenium-project/src/main/java/index.html");
    }



    @DataProvider(name = "loginData")
    public static Object[][] loginData() {
        return new Object[][] {
                {"username", "password", true},
                {"wronguser", "wrongpass", false}
        };
    }


    @Test(dataProvider = "loginData")
    void loginTest(String login, String pass, boolean bool) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.id("username")).sendKeys(login);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.tagName("button")).click();
        if (bool){
            Thread.sleep(2000);
            WebElement welcomeMessage = driver.findElement(By.tagName("h2"));
            Assert.assertEquals(welcomeMessage.getText(), "Welcome!");
        } else {
            Thread.sleep(2000);
            WebElement errorMessage = driver.findElement(By.id("errorMessage"));
            Assert.assertEquals(errorMessage.getText(), "Invalid username or password.");
        }
    }
}
