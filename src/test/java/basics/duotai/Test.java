package basics.duotai;

public class Test {

    public static void main(String[] args) {

        /**
         * 当超类变量引用子类对象时，
         * 被引用变量的类型而不是引用变量的类型决定了调用谁的成员方法，
         * 但是这个调用的方法必须是在超类中定义过的，也就是被子类覆盖的方法
         *
         * 继承链中的方法调用存在一个优先级：
         * this.show(O) 、super.show(O)、 this.show((super)O)、 super.show((super)O)
         */

        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();

        System.out.println("1.-----------" + a1.show(b));
        System.out.println("2.-----------" + a1.show(c));
        System.out.println("3.-----------" + a1.show(d));
        System.out.println("4.-----------" + a2.show(c));
        System.out.println("5.-----------" + a2.show(c));
        System.out.println("6.-----------" + a2.show(d));
        System.out.println("7.-----------" + b.show(b));
        System.out.println("8.-----------" + b.show(c));
        System.out.println("9.-----------" + b.show(d));

    }
}
