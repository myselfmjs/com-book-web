package builder;

/**
 * @Author: majunsheng
 * @Date: 2018/4/10
 * 具体建造者类
 **/
public class ConcreateBuilder implements Builder {

    private Product product = new Product();

    /**
     * 产品零件建造方法1
     */
    @Override
    public void builderPart1() {
        System.out.println("构建产品第一个零件------1");
        product.setPart1("零件编码：123");
    }

    /**
     * 产品零件建造方法2
     */
    @Override
    public void builderPart2() {
        System.out.println("构建产生第二个零件------2");
        product.setPart2("零件名称：零件One");
    }

    /**
     * 产品返回方法
     * @return
     */
    @Override
    public Product retrieveResult() {
        return product;
    }
}
