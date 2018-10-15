package decorator;

/**
 * ConcreteComponent 具体组件
 * @Author: majunsheng
 * @Date: 2018/10/15
 **/
public class Man implements Person {

    @Override
    public void eat() {

        System.out.println("男人在吃...");
    }
}
