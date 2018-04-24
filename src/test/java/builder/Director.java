package builder;

/**
 * @Author: majunsheng
 * @Date: 2018/4/10
 * 导演者类
 **/
public class Director {

    private ConcreateBuilder concreateBuilder;

    public Director(ConcreateBuilder concreateBuilder) {
        this.concreateBuilder = concreateBuilder;
    }

    public void construct(){
        concreateBuilder.builderPart1();
        concreateBuilder.builderPart2();
    }
}
