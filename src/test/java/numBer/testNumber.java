package numBer;

import java.text.DecimalFormat;

/**
 * Created by majunsheng on 2017/6/29.
 */
public class testNumber {
    public static void main(String[] args) {

        testNumber testNumber=new testNumber();
        testNumber.format("###,###.###", 11122233333.34567);
        testNumber.format("000,000.000", 11.34567);
        testNumber.format("###,###.###$", 111222.34567);
        testNumber.format("000,000.000￥", 11222.34567);
        testNumber.format("##.###%", 0.00678);        // 使用百分数形式
        testNumber.format("00.###%", 0.0345678);        // 使用百分数形式
        testNumber.format("###.###\u2030", 0.345678);    // 使用千分数形式
    }

    public void format(String pattern,double value){
        DecimalFormat df=new DecimalFormat(pattern);
        String str=df.format(value);
        System.out.println("使用" + pattern+ "\t格式化数字"+value+"：\t" + str);
    }
}
