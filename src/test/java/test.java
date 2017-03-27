import port.Singleton;

import java.math.BigDecimal;

/**
 * Created by majunsheng on 2017/3/27.
 */
public class test {
    public static void main(String[] args) {
        BigDecimal decimal = new BigDecimal(0.00);
        if (decimal.equals(BigDecimal.ZERO)){
            System.out.println("decimal=0");
        }else {
            System.out.println("decimal != 0");
        }

        Singleton singleton = Singleton.getInstance();
        singleton.setName("单例");
        System.out.println(singleton.toString());
    }
}
