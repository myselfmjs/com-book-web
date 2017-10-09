package proxy;

public class RealObject implements Interface {
    @Override
    public void doSomething() {
        System.out.println("doSomething");
    }

    @Override
    public void someThingElse(String arg) {

        System.out.println("someThingElse----" + arg);
    }
}
