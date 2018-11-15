import vo.TestVo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by majunsheng on 2017/3/27.
 */
public class test {

    public static void main(String[] args) {

        //long fid = fid(9);
        //System.out.println(fid);
        //System.out.println("--------------------");

        //long fid2 = fid2(50);
        //System.out.println(fid2);
        //System.out.println("--------------------");

        //long fid3 = fid3(93); //最大92，93会溢出 需要BigInteger
       // System.out.println(fid3);

        readJvm();
    }


    /**
     * 获取jvm的系统属性
     */
    public static void readJvm(){
        Properties pps = System.getProperties();
        pps.list(System.out);


    }

    /**
     * 菲波那切数列
     * @param n
     * @return
     */
    public static long fid(int n){

        if (n ==1 || n==2){
            return 1;
        }else {

            return fid(n-1) + fid(n-2);
        }
    }

    /**
     * 菲波那切数列 优化1
     * @param n
     * @return
     */
    public static long fid2(int n){
        long result = 1 ;
        if (n>1) {
            do {
                result += fid2(n - 2);
                n--;
            } while (n > 1);
            return result;
        }
        return n;
    }

    /**
     * 菲波那切数列 优化2
     * @param n
     * @return
     */
    public static long fid3(int n){
        if (n>1){
            long a = 0, b = 1, tmp = b;
            do {
                tmp = b;
                b += a;
                a = tmp;
            }while (--n >1);
            return b;
        }
        return n;

    }


    /**
     * 基本类型，在方法内部不可修改
     * @param i
     */
    public static void checkInt(final int i){

        // 编译报错，final修饰的基本类型，在方法内部是允许修改的
        //i = 10;
    }

    /**
     *引用类型，引用不可变，值可变
     * @param vo
     */
    public static void checkVo(final TestVo vo){

        //vo变量的引用是不能够改变的，否则的话，编译会报错
        //    vo=new TestVo();
        //vo变量的值是能够修改的，但所指向的引用是不能够改变的
        vo.setAge(12);
    }

    private static void setFileInputStream(FileInputStream inputStream){

        try {
            //保存签核图片
            String path = "D://image";
            String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".jpg";
            //文件夹不存在则创建
            File fdir = new File(path);
            if (!fdir.exists()) {
                fdir.mkdirs();
            }
            String realPath = path + "/" + fileName;
            FileOutputStream os = new FileOutputStream(new File(realPath));
            byte[] ob = new byte[1024];
            int length = 0;
            while((length = inputStream.read(ob, 0, ob.length))>0){
                os.write(ob,0,length);
                os.flush();
            }
            os.close();
        }catch (Exception ignored){

        }

    }

    /**
     * 三目运算
     * 在三目运算符中，当第二，第三位操作数分别为基本类型和对象时，其中的对象就会拆箱为基本类型进行操作。
     */
    private static void smys(){

        TestVo vo = new TestVo();
        TestVo vo02 = new TestVo();

        System.out.println("age1 ==   " + vo.getAge1());
        vo.setAge1(vo.getAge1()==null?vo02.getAge1():Double.valueOf(2));
        System.out.println("End age1 =   " + vo.getAge1());
    }

    private static void smys2(){

        Map<String, Boolean> map = new HashMap<>();
        Boolean b = map != null ? map.get("test") : false;
        System.out.println(b);
    }

}
