package proxy;

/**
 * 代理测试Demo
 */
public class SimpleProxyDome {

    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.someThingElse("bonobo");
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }

}
