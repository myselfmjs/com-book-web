package port;

/**
 * Created by majunsheng on 2017/3/27.
 * 单例模式(最优方案)
 * 线程安全  并且效率高
 */
public class Singleton {

    private String name;
    private int age;

    //定义一个静态私有变量
    // (不初始化，不使用final关键字，
    // 使用volatile保证了多线程访问时instance变量的可见性，
    // 避免了instance初始化时其他变量属性还没赋值完时，被另外线程调用)
    private static Singleton instance;

    //私有的构造方法(防止通过 new SingletonTest()去实例化)
    private Singleton() {
    }

    public static synchronized Singleton getInstance(){
        // 对象实例化时与否判断（不使用同步代码块，instance不等于null时，直接返回对象，提高运行效率）
        if (instance ==null ){
            //同步代码块（对象未初始化时，使用同步代码块，保证多线程访问时对象在第一次创建后，不再重复被创建）
            synchronized(Singleton.class){
                if (instance ==null ){
                    //未初始化，则初始instance变量
                    instance = new Singleton();
                }
            }
        }
        return  instance;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Singleton{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
