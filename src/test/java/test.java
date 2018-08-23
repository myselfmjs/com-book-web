import vo.TestVo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by majunsheng on 2017/3/27.
 */
public class test {

    public static void main(String[] args) {

        smys();
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
        }catch (Exception e){

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
        vo.setAge1(vo.getAge1()==null?vo02.getAge1():2);
        System.out.println("End age1 =   " + vo.getAge1());
    }


}
