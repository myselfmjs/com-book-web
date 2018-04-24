package thread.Bread;

/**
 * @Author: majunsheng
 * @Date: 2018/4/9
 **/
//描述资源：面包的名称和编号，由编号决定面包的号码
class Bread {
    public String name;
    public int count = 1;
    public boolean flag = false; //该标记为wait()和notify()提供判断标记
}
//生产者和消费者先后处理的面包资源是同一个，要确保这一点，
//可以按单例模式来设计面包类，也可以将同一个面包对象通过构造方法传递给生产者和消费者，此处使用后一种方式。
//描述生产者
class Producer implements Runnable {
    private Bread b; //生产者的成员：它要处理的资源
    Producer(Bread b){
        this.b = b;
    }
    //提供生产面包的方法
    public void produce(String name){
        b.name = name + b.count;
        b.count++;
    }
    public void run(){
        while(true){
            synchronized(Bread.class){ //使用Bread.class作为锁标识，使得生产者和消费者的同步代码块可以使用同一个锁
                if(b.flag){  //wait()必须在同步代码块内部，不仅因为必须持有锁才能睡眠，而且对锁这个资源的判断会出现混乱
                    try{
                        Bread.class.wait();
                    }catch(InterruptedException i){}
                }
                produce("面包");
                System.out.println(Thread.currentThread().getName()+"----生产者------"+b.name);
                try{
                    Thread.sleep(10);
                }catch(InterruptedException i){}
                b.flag = true;  //标记的切换也必须在保持同步
                Bread.class.notify(); //notify()也必须同步，否则锁都已经释放了，就无法做唤醒动作
                //ps:一次同步任务中，wait()和notify()应当只能其中一个执行，否则对方线程会混乱
            }
        }
    }
}
//描述消费者
class Consumer implements Runnable {
    private Bread b; //消费者的成员：它要处理的资源
    Consumer(Bread b){
        this.b = b;
    }
    //提供消费面包的方法
    public String consume(){
        return b.name;
    }
    public void run(){
        while(true){
            synchronized(Bread.class){
                if(!b.flag){
                    try{
                        Bread.class.wait();
                    }catch(InterruptedException i){}
                }
                System.out.println(Thread.currentThread().getName()+"----消费者-------------"+consume());
                try{
                    Thread.sleep(10);
                }catch(InterruptedException i){}
                b.flag = false;
                Bread.class.notify();
            }
        }
    }
}
public class ProduceConsume_1{
    public static void main(String[] args) {
        //1.创建资源对象
        Bread b = new Bread();
        //2.创建生产者和消费者对象，将同一个面包对象传递给生产者和消费者
        Producer pro = new Producer(b);
        Consumer con = new Consumer(b);
        //3.创建线程对象
        Thread pro_t = new Thread(pro);
        Thread con_t = new Thread(con);
        pro_t.start();
        con_t.start();
    }
}
