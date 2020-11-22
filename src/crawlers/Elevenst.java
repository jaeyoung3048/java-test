package crawlers;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Elevenst extends Crawler{
    public Elevenst(String key) {
        super();
        this.url = "https://www.11st.co.kr/";
        this.Finder = By.className("search_text");
        this.key = key;
    }

    @Override()
    public void crawl() throws InterruptedException {
        super.crawl();

        this.ItemBox = driver.findElements(By.xpath("/html/body/div[2]/div[2]/div/div[1]/div/section/ul/li/div/div[2]"));

        for (WebElement element : this.ItemBox){
            Itemtext = element.findElement(By.tagName("strong"));
            Itemmoney = element.findElement(By.className("c_prd_price")).findElement(By.tagName("dd"));
            ItemLink = element.findElement(By.tagName("a")).getAttribute("href");
            System.out.println("상품명 : "+Itemtext.getText());
            System.out.println("가격 : "+Itemmoney.getText());
            System.out.println("링크 : "+ItemLink);
        }

        driver.close();

    }
}
