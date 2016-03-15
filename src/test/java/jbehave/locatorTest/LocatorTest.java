package jbehave.locatorTest;

        import org.junit.Test;
        import org.openqa.selenium.By;
        import org.openqa.selenium.Keys;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.firefox.FirefoxDriver;

        import java.util.concurrent.TimeUnit;

/**
 * @author Sasha on 3/15/2016.
 */
public class LocatorTest {

    @Test
    public void LocatorTest() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://project.loc");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        WebElement login = driver.findElement(By.linkText("Login"));
        login.click();
        WebElement name = driver.findElement(By.id("loginform-username"));
        WebElement pswd = driver.findElement(By.id("loginform-password"));
        name.sendKeys("tester");
        pswd.sendKeys("qwertyuiop");
        WebElement btnLogin = driver.findElement(By.name("login-button"));

        btnLogin.click();
        WebElement company = driver.findElement(By.linkText("Company"));
        company.click();
        WebElement btnCreateNew = driver.findElement(By.id("btncrtcom"));
        btnCreateNew.click();
        WebElement country = driver.findElement(By.id("select2-Country-select-container"));
        country.click();
        country.sendKeys(Keys.ENTER);
        country.sendKeys(Keys.ARROW_DOWN);
        country.sendKeys(Keys.ENTER);
        WebElement inputVal;
        try {
            inputVal = driver.findElement(By.xpath(".//input[@class='select2-search__field']"));
            inputVal.sendKeys("ZZZ");
            inputVal.sendKeys(Keys.ENTER);
        } catch (Exception io) {
            io.printStackTrace();
        }


    }
}
