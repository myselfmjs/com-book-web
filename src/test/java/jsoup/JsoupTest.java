package jsoup;

import com.book.web.model.Song;
import com.book.web.model.WebPage;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * jsoup 解析Html
 *
 */
public class JsoupTest {

    public static void main(String[] args) {

        //String url = "http://www.baidu.com";
        String url = "http://music.163.com/song?id=29999506";

        try {

            Document doc = Jsoup.connect(url).get();
            //System.out.println(doc);


           /* Connection.Response response =  Jsoup.connect(url).execute();
            System.out.println(response.body());
            Elements songs =Jsoup.parse(response.body()).select("ul.f-hide li a");

            System.out.println(songs);*/




            WebPage webPage = new WebPage("http://music.163.com/song?id=29999506", WebPage.PageType.song, "test");

            String weburl = webPage.getUrl().split("=")[1];
            System.out.println(weburl);
            //Song s = new Song(webPage.getUrl(), webPage.getTitle(), getCommentCount(webPage.getUrl().split("=")[1]));


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
