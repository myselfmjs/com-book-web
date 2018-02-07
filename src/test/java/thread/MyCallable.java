package thread;

import java.util.concurrent.Callable;

/**
 * 通过FutureTask 和 Callable 创建线程
 */
public class MyCallable implements Callable<Integer> {

    private int i = 0;

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (i = 0; i<50; i++){
            System.out.println(Thread.currentThread().getName() + "---" + i);
            sum += i;
        }

        return sum;
    }
}
