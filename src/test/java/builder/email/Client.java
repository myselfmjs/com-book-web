package builder.email;

/**
 * @Author: majunsheng
 * @Date: 2018/4/11
 * 客户端
 **/
public class Client {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Builder builder = new WelcomeBuilder();
        Director director = new Director(builder);
        director.construct("toAddress@126.com", "fromAddress@126.com");

        Builder builder1 = new GoodbyeBuilder();
        Director director1 = new Director(builder1);
        director1.construct("@666.com","@777.com");

    }

}
