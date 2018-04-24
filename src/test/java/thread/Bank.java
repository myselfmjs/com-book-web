package thread;

/**
 * @Author: majunsheng
 * @Date: 2018/4/9
 *
 * 创建一个Bank类
 **/
public class Bank {


    //假设一个账户有1000元
    static int money = 1000;

    //柜台Counter取钱的方法
    public void Counter(int money){
        Bank.money -= money;
        System.out.println("Counter柜台取走了：" + money);
    }

    //ATM取钱的方法
    public void Atm(int money){
        Bank.money -=money;
        System.out.println("AMT取走了：" + money);
    }
}
