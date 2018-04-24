package thread;

/**
 * @Author: majunsheng
 * @Date: 2018/4/9
 * 银行取钱操作，测试方法main
 **/
public class TheardMain {
    public static void main(String[] args) {
        Bank bank = new Bank();
        PersonA a = new PersonA(bank);
        PersonB b = new PersonB(bank);

        a.start();
        b.start();
    }
}
