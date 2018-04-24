package thread;

/**
 * @Author: majunsheng
 * @Date: 2018/4/9
 *
 * 取钱人A 柜台操作
 **/
public class PersonA  extends Thread{

    Bank bank;

    //通过构造方法初始化传入银行，确保两人进入是一个银行
    public PersonA(Bank bank) {
        this.bank = bank;
    }

    //重写Run方法，实现使用柜台取钱
    @Override
    public void run() {

        while (bank.money>100){
            bank.Counter(100); //每次取100
            try{
                sleep(100); //取完休息0.1秒
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
