package Stream;

import java.io.*;

public class InputStreamTest {

    public static void main(String[] args) {


        getInputStream();

        //getObjectStream();
    }

    public static void getInputStream(){

        File f = new File("D:\\tt.txt");
        File f2 = new File("D:\\tttt.txt");

        byte[] buffer = new byte[512];

        char[] charbuffer = new char[255];


        if (!f2.exists()){
            try {
                f2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileInputStream in = null;
        FileOutputStream outFile = null;

        InputStreamReader inReamder = null;
        OutputStreamWriter outwriter = null;
        BufferedWriter bos = null;

        int ch = 0;
        int count = 0;

        try {
            in = new FileInputStream(f);
            outFile = new FileOutputStream(f2);

            inReamder = new InputStreamReader(in,"GBK");
            outwriter = new OutputStreamWriter(outFile,"GBK");

            bos = new BufferedWriter(outwriter);

            /*while ((ch = in.read(buffer)) != -1){
                count ++;
                String str = new String(buffer,"GBK");
                System.out.print(str);
                outFile.write(buffer,0,ch);  //ch 防止最后一次读取的字节数小于buffer的长度
            }*/


            while ((ch = inReamder.read()) != -1){
                count ++;
                System.out.print((char)ch);
                bos.write(ch);
                bos.flush();
            }

            System.out.println("count长度是= " + count);

        } catch (IOException  e) {
            e.printStackTrace();
        }finally {
            if (in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inReamder !=null){
                try {
                    inReamder.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                outFile.close();
                outwriter.close();
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void getObjectStream(){

        ObjectInputStream objread = null;
        ObjectOutputStream objwriter = null;

        try {
            objwriter = new ObjectOutputStream(new FileOutputStream("C:\\Users\\majunsheng\\Desktop\\Linux入门2.txt"));
            objwriter.writeObject(new Student("gg","12"));
            objwriter.writeObject(new Student("AA","13"));
            objwriter.writeObject(new Student("TT","15"));

            objread = new ObjectInputStream(new FileInputStream("C:\\Users\\majunsheng\\Desktop\\Linux入门2.txt"));

            for (int i=0;i<3; i++){
                System.out.println(objread.readObject());
            }

        } catch (IOException |ClassNotFoundException  e) {
            e.printStackTrace();
        }finally {
            if (objread != null){
                try {
                    objread.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (objwriter !=null){
                try {
                    objwriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
