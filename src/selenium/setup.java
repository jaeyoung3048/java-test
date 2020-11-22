package selenium;

import crawlers.Auction;
import crawlers.Crawler;
import crawlers.Elevenst;
import crawlers.Gmarket;
import java.util.Scanner;

public class setup {
    public static int utterance;
    public static String word;

    public static void main(String[] args) throws InterruptedException {
        Crawler crawl;
        Scanner sc = new Scanner(System.in);
        Scanner Keyword = new Scanner(System.in);

        while (true){
            System.out.printf("사용할 쇼핑몰을 선택해주세요!\n1.G마켓\n2.11번가\n3.옥션\n4.모두\n5.종료\n입력: ");
            utterance = sc.nextInt();
            if (utterance == 5){
                break;
            }
            System.out.printf("검색어를 입력해주세요: ");
            word = Keyword.nextLine();

            switch (utterance) {
                case 1:
                    crawl = new Gmarket(word);
                    crawl.crawl();
                    break;
                case 2:
                    crawl = new Elevenst(word);
                    crawl.crawl();
                    break;
                case 3:
                    crawl = new Auction(word);
                    crawl.crawl();
                    break;
                case 4:
                    crawl = new Auction(word);
                    crawl.crawl();
                    crawl = new Elevenst(word);
                    crawl.crawl();
                    crawl = new Gmarket(word);
                    crawl.crawl();
                    break;
                default:
                    System.out.println("다시 입력해주세요!");
            }
        }
    }
}

