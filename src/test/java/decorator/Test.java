package decorator;

/**
 * @Author: majunsheng
 * @Date: 2018/10/15
 **/
public class Test {

    public static void main(String[] args) {

        Man man = new Man();
        ManDecoratorA manDecoratorA = new ManDecoratorA();
        ManDecoratorB manDecoratorB = new ManDecoratorB();

        //manDecoratorA.setPerson(man);
        //manDecoratorA.eat();

        manDecoratorB.setPerson(manDecoratorA);
        manDecoratorB.eat();
    }
}
