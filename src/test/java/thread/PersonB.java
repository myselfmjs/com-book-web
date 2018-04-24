package thread;

/**
 * @Author: majunsheng
 * @Date: 2018/4/9
 *
 * 取钱人B ATM操作
 **/
public class PersonB extends Thread{

    Bank bank;

    //通过构造方法初始化传入银行，确保两人进入是一个银行
    public PersonB(Bank bank) {
        this.bank = bank;
    }

    //重写Run方法，实现使用柜台取钱
    @Override
    public void run() {

        while (bank.money>200){
            bank.Atm(200); //每次取200
            try{
                sleep(100); //取完休息0.1秒
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
