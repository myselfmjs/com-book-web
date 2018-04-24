package basics.sx;

/**
 * @Author: majunsheng
 * @Date: 2018/4/19
 * 子类父类的执行顺序
 **/
public class Son extends Father {

    private static String sonStatic; //静态成员变量

    private String sonStr; //变量

    //无参构造方法
    public Son(){
        System.out.println("Son--无参构造方法");
    }

    //有参构造方法
    public Son(String sonStr){
        System.out.println("Son---有参构造方法");
    }

    //代码块
    {
        System.out.println("Son---代码块");
    }

    //静态代码块
    static {
        System.out.println("Son--静态代码块");
    }


}
