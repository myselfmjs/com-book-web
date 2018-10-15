package decorator;

/**
 * ConcreteDecorator 具体装饰
 * @Author: majunsheng
 * @Date: 2018/10/15
 **/
public class ManDecoratorA extends Decorator {

    public void eat(){
        super.eat();
        reEat();
        System.out.println("ManDecoratorA 类");
    }

    public void reEat(){
        System.out.println("ManDecoratorA 在吃一顿....");
    }

}
