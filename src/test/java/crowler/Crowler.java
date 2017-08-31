package crowler;

/**
 * Created by majunsheng on 2017/8/31.
 */
public class Crowler {
    public static void main(String[] args) {
        try {
            // 抓取百度首页，输出
            Spider.downloadPage("http://www.baidu.com");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
