package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ThreadTest {

    public static void main(String[] args) {


        getCallable();
    }



    //1.MyThread 创建的线程
    public static void getMyThread(){
        for (int i=0;i<50;i++){
            System.out.println(Thread.currentThread().getName() + "---" + i);
            if (i==20){


                Thread t1 = new MyThread();
                Thread t2 = new MyThread();

                t1.start();
                t2.start();
            }
        }
    }

    // 2.Runnable 创建的线程
    public static void getRunnable(){
        for (int i = 0 ;i<50; i++){
            System.out.println(Thread.currentThread().getName() + "---" + i);
            if (i==20){

                Runnable r = new MyRunnable();
                Thread t = new Thread(r);
                t.start();
            }
        }
    }

    // 3.Thread 于 Runnable 同时参与创建
    public static void getThreadRun(){
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "--- " + i);
              if (i == 20) {
                  Runnable myRunnable = new MyRunnable(); // 创建一个Runnable实现类的对象
                        Thread thread1 = new Thread(myRunnable); // 将myRunnable作为Thread target创建新的线程
                        Thread thread2 = new Thread(myRunnable);
                        thread1.start(); // 调用start()方法使得线程进入就绪状态
                        thread2.start();
                    }
        }
    }

    // 4.通过FutureTask 和 Callable 创建线程
    public static void getCallable(){

        Callable<Integer> myCallable = new MyCallable();
        FutureTask<Integer> myFutureTask = new FutureTask<Integer>(myCallable);

        for (int i = 0; i<50; i++){
            System.out.println(Thread.currentThread().getName() + "---" +i);

            if (i == 20 ){
                Thread t =new Thread(myFutureTask);
                t.start();
            }
        }
    }
}
