package crawlers;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Auction extends Crawler {
    public Auction(String key) {
        super();
        this.url = "http://www.auction.co.kr/";
        this.Finder = By.className("search_input_keyword");
        this.key = key;
    }

    @Override()
    public void crawl() throws InterruptedException {
        super.crawl();

        this.ItemBox = driver.findElements(By.className("section--itemcard_info_major"));

        for (WebElement element: this.ItemBox){
            this.Itemtext = element.findElement(By.className("text--itemcard_title")).findElement(By.tagName("a")).findElement(By.className("text--title"));
            this.Itemmoney = element.findElement(By.className("price_seller")).findElement(By.className("text--price_seller"));
            this.ItemLink = element.findElement(By.className("text--itemcard_title")).findElement(By.tagName("a")).getAttribute("href");
            System.out.println("상품명 : "+ this.Itemtext.getText());
            System.out.println("가격 : "+ this.Itemmoney.getText());
            System.out.println("링크 : "+this.ItemLink);
        }

        driver.close();
    }

}
