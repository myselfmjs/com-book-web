package decorator;

/**
 * ConcreteDecorator 具体装饰
 * @Author: majunsheng
 * @Date: 2018/10/15
 **/
public class ManDecoratorB extends Decorator {

    public void eat(){
        super.eat();
        reEat();
        System.out.println("ManDecoratorB 类");
    }

    public void reEat(){
        System.out.println("ManDecoratorB 在吃一顿....");
    }

}
