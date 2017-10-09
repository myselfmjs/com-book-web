package basics;


/**
 * 路虎汽车
 */
public class LhCar extends Car {

    public void fun1(String a){
        System.out.println("子类路虎的-----fun1");
        fun2();
    }

    @Override
    public void fun2(){
        System.out.println("子类路虎的-----fun2");
    }
}
