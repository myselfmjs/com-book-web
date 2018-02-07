package thread;

/**
 * 线程
 * 实现Runnable接口，并重写该接口的run()方法
 */
public class MyRunnable implements Runnable {

    private int i = 0;

    @Override
    public void run() {

        for(i = 0;i<20;i++){
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
