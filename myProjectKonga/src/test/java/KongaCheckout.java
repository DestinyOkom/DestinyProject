import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

// DESTINY'S PROJECT

public class KongaCheckout {

    private WebDriver driver;

    @Test(priority = 0)

    public void start() throws InterruptedException {
        //locate where the chrome driver is
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
       //1. open your chrome browser
        driver = new ChromeDriver();

        //2. Visit the Konga Url
        driver.get("https://www.konga.com/");
        Thread.sleep(30000);

        //3. maximize your screen
        driver.manage().window().maximize();

        //4. click on the signIn button
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")). click();
        Thread.sleep(30000);
    }

    @Test (priority = 1)
    public void negativeSignIn() throws InterruptedException {
        //5. Input email address and password
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("ashikem2025@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("password");

        //6. Click Login Button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(30000);
    }

    @Test (priority = 2)
    public void ItemShopping() throws InterruptedException {

        //7. From the Categories, click on the“Computers and Accessories”
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]")).click();
        Thread.sleep(30000);

        //8. Click on the Laptop SubCategory
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[4]/a/label/span")).click();
        Thread.sleep(30000);

        //9. Click on the Apple MacBooks
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[4]/a/ul/li[1]/a/label/span")).click();
        Thread.sleep(30000);

        //10. Add an item to the cart
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[7]/div/div/div[2]/form/div[3]/button")).click();
        Thread.sleep(30000);


    }

    @Test (priority = 3)
    public void CompleteOrderAndPayment() throws InterruptedException {

        //11. Proceed to CheckOut
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/a[2]/span[1]")).click();
        Thread.sleep(30000);
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[3]/div/div[2]/button")).click();
        Thread.sleep(30000);

        //12. Add delivery address
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/main/div/form/div/div[1]/section[1]/div/div/div[2]/div[1]/div[2]/div[1]/div/button")).click();
        Thread.sleep(30000);

        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[2]/div/div/div[2]/div[1]/form/button")).click();
        //Thread.sleep(30000);

        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[3]/div/div/div/a")).click();
        //Thread.sleep(30000);

        //13. Select a card payment option
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
        Thread.sleep(30000);

        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
        Thread.sleep(30000);

        driver.findElement(By.xpath("//*[@id=\"channel-template\"]/div[2]/div/div[2]/button")).click();
        Thread.sleep(30000);

    }


    @Test (priority = 4)
    public void printError() throws InterruptedException {

        //14. Input invalid card details
        driver.findElement(By.xpath("//*[@id=\"card-number\"]")).sendKeys("1234 1234 1234");

        driver.findElement(By.xpath("//*[@id=\"expiry\"]")).sendKeys("05/16");

        driver.findElement(By.xpath("//*[@id=\"cvv\"]")).sendKeys("125");

        //15. Print Out the error message:Invalid card number
        String err_msg = driver.findElement(By.xpath("//*[@id=\"card-number_unhappy\"]")).getText();
        Thread.sleep(10000L);

        String expect = "Invalid card number";
        Thread.sleep(9000L);


        Assert.assertEquals(err_msg, expect);


        System.out.println("Error message is: " + err_msg);
        Thread.sleep(9000L);

        //16. Close the Frame that displays the input card Modal

        driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[1]/aside")).click();
        Thread.sleep(30000);
    }



    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}

