package basics;

/**
 * 父类
 * 汽车 car
 */
public class Car {

    public void fun1(){
        System.out.println("父类的-----fun1");
        fun2();
    }

    public void fun2(){
        System.out.println("父类的-----fun2");
    }
}
