package basics.fanshe;

/**
 * @Author: majunsheng
 * @Date: 2018/5/8
 * 反射机制测试
 **/
public class Test {

    public static void main(String[] args) {

        try {
            Class fsClass = Class.forName("FsClass");
            FsClass fs = (FsClass) fsClass.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }


    }
}
