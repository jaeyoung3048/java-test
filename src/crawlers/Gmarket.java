package crawlers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Gmarket extends Crawler {
    public Gmarket(String key) {
        super();
        this.url = "https://www.gmarket.co.kr/";
        this.Finder = By.xpath("//*[@id=\"skip-navigation-search\"]/span/input");
        this.key = key;
    }

    @Override()
    public void crawl() throws InterruptedException {
        super.crawl();
        this.ItemBox = driver.findElements(By.className("box__information-major"));

        for (WebElement element: this.ItemBox){
            Itemtext = element.findElement(By.className("box__item-title")).findElement(By.className("text__item"));
            Itemmoney = element.findElement(By.className("box__price-seller")).findElement(By.tagName("strong"));
            ItemLink = element.findElement(By.className("box__item-title")).findElement(By.tagName("a")).getAttribute("href");
            System.out.println("상품명 : "+Itemtext.getAttribute("title"));
            System.out.println("가격 : "+Itemmoney.getText());
            System.out.println("링크 : "+ItemLink);
        }
        driver.close();
    }
}
