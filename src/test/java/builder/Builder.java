package builder;

/**
 * @Author: majunsheng
 * @Date: 2018/4/10
 * 抽象建造者类Builder
 **/
public interface Builder {

    public void builderPart1();

    public void builderPart2();

    public Product retrieveResult();

}
