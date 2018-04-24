package builder;

/**
 * @Author: majunsheng
 * @Date: 2018/4/10
 * 客户端
 **/
public class Client {

    public static void main(String[] args) {

        ConcreateBuilder concreateBuilder = new ConcreateBuilder();
        Director director = new Director(concreateBuilder);
        Product product = concreateBuilder.retrieveResult();
        director.construct();
        //Product product = concreateBuilder.retrieveResult();
        System.out.println(product.getPart1());
        System.out.println(product.getPart2());
    }
}
