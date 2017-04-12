package instance;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
/**
 * Created by majunsheng on 2017/3/29.
 * Java反射机制
 */
public class reflectDemo {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        //通过一个对象获得完整的包名和类名
        // TestReflect();

        //实例化Class对象
        //InstanReflect();

        //获取某个类的全部属性
         RefTest();

        //获取某个类的全部方法
        //MethodTest();

        //调用某个类的方法
        //MethodGet();

    }

    //通过一个对象获得完整的包名和类名
    public static void TestReflect(){
        reflectDemo reflectDemo = new reflectDemo();
        String name = reflectDemo.getClass().getName();

        System.out.println("TestReflect对象的完整包名和类名--："+name);
    }

    //实例化Class对象
    public static void InstanReflect() throws ClassNotFoundException {
        Class<?> class1 = null;
        Class<?> class2 = null;
        Class<?> class3 = null;

        class1 = new reflectDemo().getClass();
        class2 = Class.forName("test.reflect.reflectDemo");
        class3 = reflectDemo.class;

        //getSuperclass 获取对象的父类
        System.out.println("父类名称   " + class1.getSuperclass().getName());
        System.out.println("类名称   " + class2.getName());
        System.out.println("类名称   " + class3.getName());
    }

    /**
     * 获取某个类的全部属性
     */
    private static void RefTest() throws ClassNotFoundException {

        Class<?> aClass = Class.forName("pojo.Artist");
        Field[] fields = aClass.getDeclaredFields();
        for(int i=0;i<fields.length; i++){
            //权限修饰符
            int modifiers = fields[i].getModifiers();
            String par = Modifier.toString(modifiers);
            //属性类型
            Class<?> type = fields[i].getType();

            System.out.println(par + "-" + type.getName() + "-" + fields[i].getName());

        }
    }
    /**
     * 获取某个类的全部方法
     */
    private static void MethodTest() throws ClassNotFoundException {
        Class<?> aClass = Class.forName("pojo.Artist");
        Method[] methods = aClass.getMethods();

        for (int i=0; i<methods.length; i++){
            //权限修饰符
            int modifiers = methods[i].getModifiers();
            //方法返回类型
            Class<?> returnType = methods[i].getReturnType();

            //方法中参数的类型
            /*Class<?>[] parameterTypes = methods[i].getParameterTypes();
            for (int j = 0; j < parameterTypes.length; ++j) {
                System.out.print(parameterTypes[j].getName() + " " + "arg" + j);
                if (j < parameterTypes.length - 1) {
                    System.out.print(",");
                }
            }*/

            System.out.println(Modifier.toString(modifiers));
            System.out.println(returnType.getName());
        }
    }
    private static void MethodGet() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> aClass = Class.forName("pojo.Student");
        //无参调用
        Method method = aClass.getMethod("GetInvoke");
        Object invoke = method.invoke(aClass.newInstance());

        //有参调用并赋值
        Method method1 = aClass.getMethod("getStudent", String.class, int.class);
        Object invoke1 = method1.invoke(aClass.newInstance(), "张三", 25);

        System.out.println(invoke.toString());
        System.out.println(invoke1.toString());
    }
}
