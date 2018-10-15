package Client;


import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.IOException;

/**
 * @Author: majunsheng
 * @Date: 2018/9/26
 * HttpClient 测试
 **/
public class ClientTest {
    public static void main(String[] args) throws IOException {
        HttpCLientPost();
    }

    public void HttpCLientGet() throws IOException {
        //创建一个客户端，类似于打开一个浏览器
        HttpClient httpClient = new HttpClient();

        //创建一个get方法，类似于浏览器中输入地址
        GetMethod getMethod = new GetMethod();

        //回车，获取响应代码
        int statusCode = httpClient.executeMethod(getMethod);
        System.out.println(statusCode);

        //查看命中情况
        System.out.println("response= " + getMethod.getResponseBodyAsString());

        //释放
        getMethod.releaseConnection();
    }


    public static void HttpCLientPost() throws IOException {
        //创建一个客户端，类似于打开一个浏览器
        HttpClient httpClient = new HttpClient();

        //创建一个post方法，类似于浏览器中输入地址
        PostMethod postMethod = new PostMethod("http://www.baidu.com");

        //使用数组传递参数
        NameValuePair[] valuePairs = new NameValuePair[2];
        valuePairs[0] = new NameValuePair("前段开发", "HTML");
        valuePairs[1] = new NameValuePair("后端开发", "JAVA");

        //设置参数
        postMethod.addParameters(valuePairs);

        //回车，获取响应代码
        int statusCode = httpClient.executeMethod(postMethod);
        System.out.println(statusCode);

        //查看命中情况
        System.out.println("response= " + postMethod.getResponseBodyAsString());
        System.out.println("NameValuePair[0] " + postMethod.getParameters()[0]);
        System.out.println("NameValuePair[1] " + postMethod.getParameters()[1]);

        //释放
        postMethod.releaseConnection();

    }
}
