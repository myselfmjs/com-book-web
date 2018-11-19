package innerClass;

/**
 * @Author: majunsheng
 * @Date: 2018/11/19
 * 静态内部类
 **/
public class StaticInnerClassTest {
    public int outField1 = 1;

    public StaticInnerClassTest() {
        System.out.println("创建 " + this.getClass().getSimpleName() + " 对象");
        // 创建静态内部类对象
        StaticClass innerObj = new StaticClass();
        System.out.println("其内部类的 field1 字段的值为: " + innerObj.field1);
        System.out.println("其内部类的 field2 字段的值为: " + innerObj.field2);
        System.out.println("其内部类的 field3 字段的值为: " + innerObj.field3);
        System.out.println("其内部类的 field4 字段的值为: " + innerObj.field4);
    }

    static class StaticClass {

        public int field1 = 1;
        protected int field2 = 2;
        int field3 = 3;
        private int field4 = 4;
        // 静态内部类中可以定义 static 属性
        static int field5 = 5;

        public StaticClass() {
            System.out.println("创建 " + StaticClass.class.getSimpleName() + " 对象");
            //无法访问外部类的非静态成员
            //System.out.println("其外部类的 field1 字段的值为: " + outField1); // 编译错误！！
        }
    }

    public static void main(String[] args) {
        // 无需依赖外部类对象，直接创建内部类对象
        //StaticInnerClassTest.StaticClass staticClassObj = new StaticInnerClassTest.StaticClass();
        StaticInnerClassTest outerObj = new StaticInnerClassTest();
    }
}
