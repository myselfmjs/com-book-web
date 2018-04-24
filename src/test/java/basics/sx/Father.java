package basics.sx;

/**
 * @Author: majunsheng
 * @Date: 2018/4/19
 * 子类父类的执行顺序
 **/
public class Father {

    private static String fatherSta; //静态变量

    private String fatherStr; //变量

    //无参构造方法
    public Father(){
        System.out.println("Father ---无参构造烦方法");
    }

    //有参构造方法
    public Father(String fatherStr){
        System.out.println("Father ---有参构造方法");
    }

    //代码快
    {
        System.out.println("Father ---代码块");
    }

    //静态代码块
    static {
        System.out.println("Father ---静态代码块");
    }
}
