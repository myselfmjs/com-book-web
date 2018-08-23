package numBer;

import java.text.NumberFormat;

/**
 * @Author: majunsheng
 * @Date: 2018/5/7
 * 测试类NumberFormat
 **/
public class TestNumberFormat {

    public static void main(String[] args) {

        int myNumber[] = {123,345,567,789,890};

        NumberFormat nf =  NumberFormat.getPercentInstance();

        for (int i=0; i<myNumber.length;i++){
            System.out.println(nf.format(myNumber[i]));
        }

    }
}
