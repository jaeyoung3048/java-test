package crawlers;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class Crawler {
    public WebDriver driver;
    public String key;
    public By Finder;

    private static String WEB_DRIVER_ID = "webdriver.chrome.driver";
    private static String WEB_DRIVER_PATH = "/Users/jaeyoung/Documents/selenium/driver";

    public String url;
    public List<WebElement> ItemBox;
    public WebElement Itemtext;
    public WebElement Itemmoney;
    public String ItemLink;

    public Crawler(){
        System.setProperty(this.WEB_DRIVER_ID, this.WEB_DRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");

        this.driver = new ChromeDriver(options);
    }

    public void crawl() throws InterruptedException {
        driver.get(this.url);
        Thread.sleep(3000);

        this.searchFrom().sendKeys(this.key, Keys.RETURN);

        Thread.sleep(3000);
        System.out.println("검색 결과를 확인 중입니다..");
    }

    protected WebElement searchFrom() {
        return driver.findElement(this.Finder);
    }
}
