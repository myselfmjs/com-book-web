package proxy;

public class SimpleProxy implements Interface {

    private Interface proxy;

    public SimpleProxy(Interface proxy) {
        this.proxy = proxy;
    }

    @Override
    public void doSomething() {

        System.out.println("simpleProxy doSomething");
        proxy.doSomething();
    }

    @Override
    public void someThingElse(String arg) {

        System.out.println("simpleProxy someThingElse-----" + arg);
        proxy.someThingElse(arg);

    }
}
