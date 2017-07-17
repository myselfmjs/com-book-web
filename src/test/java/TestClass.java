import java.text.DecimalFormat;

/**
 * Created by majunsheng on 2017/7/17.
 */
public class TestClass {
    TestClass A;

    public void format(String pattern,double value){
        DecimalFormat df=new DecimalFormat(pattern);
        String str=df.format(value);
        System.out.println("使用" + pattern+ "\t格式化数字"+value+"：\t" + str);
    }

    public TestClass getA() {
        return A;
    }

    public void setA(TestClass a) {
        A = a;
    }
}
