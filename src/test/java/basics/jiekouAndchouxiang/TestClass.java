package basics.jiekouAndchouxiang;

/**
 * @Author: majunsheng
 * @Date: 2018/4/27
 **/
public class TestClass {

    public static void main(String[] args) {
        ClassVo classVo = new ClassVo();
        classVo.interface01();
        System.out.println(classVo.str);

        classVo.abstract02();

        Interface face = new ClassVo();

        String str = Interface.str;
    }
}
